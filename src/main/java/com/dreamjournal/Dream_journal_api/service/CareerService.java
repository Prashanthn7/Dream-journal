package com.dreamjournal.Dream_journal_api.service;

import com.dreamjournal.Dream_journal_api.model.CareerSuggestion;

import java.util.List;

public interface CareerService {
    String suggestCareer(Long userId, String dreamText);
    List<CareerSuggestion> getCareerSuggestions(Long userId);

}

