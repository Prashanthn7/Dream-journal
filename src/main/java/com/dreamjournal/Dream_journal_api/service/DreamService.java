package com.dreamjournal.Dream_journal_api.service;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DreamService {
    String saveDream(Long userId,Dream dream);
}
