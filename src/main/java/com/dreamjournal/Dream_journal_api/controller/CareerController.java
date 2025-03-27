package com.dreamjournal.Dream_journal_api.controller;

import com.dreamjournal.Dream_journal_api.model.CareerSuggestion;
import com.dreamjournal.Dream_journal_api.service.CareerService;
import com.dreamjournal.Dream_journal_api.util.ResponseBuilder;
import com.dreamjournal.Dream_journal_api.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/career-suggestions")
@AllArgsConstructor
public class CareerController {
    private final CareerService careerService;

    @PostMapping("/{userId}")
    public ResponseEntity<ResponseStructure<String>> suggestCareer(@PathVariable Long userId, @RequestBody String dreamText) {
        String response = careerService.suggestCareer(userId, dreamText);
        return ResponseBuilder.success(HttpStatus.CREATED, "Career suggestion saved", response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<List<CareerSuggestion>>> getUserCareerSuggestions(@PathVariable Long userId) {
        List<CareerSuggestion> suggestions = careerService.getCareerSuggestions(userId);
        return ResponseBuilder.success(HttpStatus.OK, "Career suggestions retrieved", suggestions);
    }
}