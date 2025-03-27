package com.dreamjournal.Dream_journal_api.service.Impl;

import com.dreamjournal.Dream_journal_api.exception.UserNotFoundByIdException;
import com.dreamjournal.Dream_journal_api.model.CareerSuggestion;
import com.dreamjournal.Dream_journal_api.model.Dream;
import com.dreamjournal.Dream_journal_api.model.User;
import com.dreamjournal.Dream_journal_api.repository.CareerRepository;
import com.dreamjournal.Dream_journal_api.repository.DreamRepository;
import com.dreamjournal.Dream_journal_api.repository.UserRepository;
import com.dreamjournal.Dream_journal_api.service.CareerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;
    private final UserRepository userRepository;
    private final DreamRepository dreamRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String API_URL = "https://ai-dream-interpretation-dream-dictionary-dream-analysis.p.rapidapi.com/dreamDictionary?noqueue=1";
    private static final String API_KEY = "a98f8326e0msh37a32256258f34ep1150efjsn56f920887285";

    @Override
    public String suggestCareer(Long userId, String dreamText) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("User not found with ID: " + userId));

        Dream dream = saveDream(user, dreamText);

        // Extract the symbol from the dream text
        String dreamSymbol = extractSymbolFromDreamText(dreamText);

        Map<String, Object> responseBody = fetchCareerSuggestionFromAPI(dreamSymbol);
        if (responseBody != null && responseBody.containsKey("career")) {
            return saveCareerSuggestion(user, responseBody);
        } else {
            throw new RuntimeException("Failed to fetch career suggestion or career field is missing in the response");
        }
    }

    private Dream saveDream(User user, String dreamText) {
        Dream dream = new Dream();
        dream.setUser(user);
        dream.setDreamText(dreamText);
        dream.setRecordedAt(LocalDate.now());
        return dreamRepository.save(dream);
    }

    private String extractSymbolFromDreamText(String dreamText) {
        // Check for common symbols in the dream text
        if (dreamText.contains("snake")) {
            return "Snake";
        } else if (dreamText.contains("pilot")) {
            return "Pilot";
        } else if (dreamText.contains("doctor") || dreamText.contains("medicine")) {
            return "Doctor";
        } else if (dreamText.contains("fire")) {
            return "Fire";
        } else if (dreamText.contains("water")) {
            return "Water";
        } else if (dreamText.contains("bird")) {
            return "Bird";
        } else if (dreamText.contains("car")) {
            return "Car";
        } else if (dreamText.contains("dog")) {
            return "Dog";
        } else if (dreamText.contains("cat")) {
            return "Cat";
        } else if (dreamText.contains("school")) {
            return "School";
        } else if (dreamText.contains("money")) {
            return "Money";
        } else if (dreamText.contains("love")) {
            return "Love";
        } else if (dreamText.contains("family")) {
            return "Family";
        } else if (dreamText.contains("death")) {
            return "Death";
        } else if (dreamText.contains("travel")) {
            return "Travel";
        } else if (dreamText.contains("baby")) {
            return "Baby";
        } else if (dreamText.contains("food")) {
            return "Food";
        } else if (dreamText.contains("work")) {
            return "Work";
        } else if (dreamText.contains("house")) {
            return "House";
        } else if (dreamText.contains("tree")) {
            return "Tree";
        } else {
            return "Unknown"; // Default if no specific symbol is found
        }
    }

    private Map<String, Object> fetchCareerSuggestionFromAPI(String dreamSymbol) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-rapidapi-key", API_KEY);
        headers.set("x-rapidapi-host", "ai-dream-interpretation-dream-dictionary-dream-analysis.p.rapidapi.com");

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("symbol", dreamSymbol); // Send extracted symbol
        requestBody.put("language", "en");

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = null;

        try {
            response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, Map.class);
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new RuntimeException("API returned an error: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error calling the API: " + e.getMessage(), e);
        }
    }

    private String saveCareerSuggestion(User user, Map<String, Object> responseBody) {
        String suggestedCareer = (String) responseBody.get("career");
        double confidenceScore = ((Number) responseBody.get("confidence")).doubleValue();
        String courseSuggestions = getCoursesForCareer(suggestedCareer);

        CareerSuggestion careerSuggestion = new CareerSuggestion();
        careerSuggestion.setUser(user);
        careerSuggestion.setSuggestedCareer(suggestedCareer);
        careerSuggestion.setCourses(courseSuggestions);
        careerSuggestion.setConfidenceScore(confidenceScore);

        careerRepository.save(careerSuggestion);
        return "Career and course suggestions saved successfully";
    }

    private String getCoursesForCareer(String career) {
        Map<String, String> careerCourses = new HashMap<>();
        careerCourses.put("Pilot", "Aviation Training, Commercial Pilot License (CPL), Aeronautical Engineering");
        careerCourses.put("Doctor", "MBBS, Medical Science, Biology, Surgery Specialization");
        careerCourses.put("Software Engineer", "Computer Science, Java Programming, Full Stack Development, Data Structures & Algorithms");
        careerCourses.put("Artist", "Fine Arts, Graphic Design, Animation, Digital Art");
        careerCourses.put("Data Scientist", "Data Science, Machine Learning, Python, Statistics, Artificial Intelligence");
        careerCourses.put("Civil Engineer", "Structural Engineering, Construction Management, Architecture, AutoCAD");
        careerCourses.put("Mechanical Engineer", "Mechanical Design, Thermodynamics, Robotics, Mechatronics");
        careerCourses.put("Electrical Engineer", "Circuit Design, Embedded Systems, Power Systems, Electronics");
        careerCourses.put("Lawyer", "LLB, Constitutional Law, Corporate Law, Criminal Law");
        careerCourses.put("Psychologist", "Psychology, Cognitive Science, Counseling, Behavioral Therapy");
        careerCourses.put("Entrepreneur", "Business Management, Marketing, Finance, Start-up Strategy");
        careerCourses.put("Journalist", "Mass Communication, Media Studies, Investigative Journalism");
        careerCourses.put("Teacher", "Education, Pedagogy, Special Education, Child Development");
        careerCourses.put("Chef", "Culinary Arts, Food Science, Hospitality Management, Baking & Pastry");
        careerCourses.put("Fashion Designer", "Fashion Technology, Textile Design, Pattern Making, Styling");
        careerCourses.put("Musician", "Music Production, Sound Engineering, Instrument Training, Vocal Coaching");
        careerCourses.put("Biotechnologist", "Biotechnology, Genetics, Molecular Biology, Bioinformatics");
        careerCourses.put("Cybersecurity Expert", "Ethical Hacking, Network Security, Cyber Law, Cryptography");
        careerCourses.put("Astronomer", "Astrophysics, Space Science, Cosmology, Rocket Science");
        careerCourses.put("Environmental Scientist", "Environmental Engineering, Ecology, Sustainable Development, Climate Change Studies");
        careerCourses.put("Game Developer", "Game Design, Unity 3D, Unreal Engine, Computer Graphics");

        return careerCourses.getOrDefault(career, "General Career Development Courses");
    }

    @Override
    public List<CareerSuggestion> getCareerSuggestions(Long userId) {
        return careerRepository.findByUser_Id(userId);
    }

    public List<CareerSuggestion> suggestCareersForAllDreams(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("User not found with ID: " + userId));

        List<Dream> dreams = dreamRepository.findByUserId(userId);
        List<CareerSuggestion> suggestions = new ArrayList<>();

        for (Dream dream : dreams) {
            String careerSuggestionText = suggestCareer(userId, dream.getDreamText());
            if (careerSuggestionText != null) {
                CareerSuggestion careerSuggestion = new CareerSuggestion();
                careerSuggestion.setUser(user);
                careerSuggestion.setSuggestedCareer(careerSuggestionText);
                careerSuggestion.setCourses(getCoursesForCareer(careerSuggestionText));
                suggestions.add(careerSuggestion);
            }
        }
        return suggestions;
    }
}
