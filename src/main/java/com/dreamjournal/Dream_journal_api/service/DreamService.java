package com.dreamjournal.Dream_journal_api.service;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.model.Dream;

import java.util.List;


public interface DreamService {
    List<DreamResponse> getDreamsByUserId(Long userId);
}
