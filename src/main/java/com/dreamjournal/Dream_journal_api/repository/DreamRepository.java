package com.dreamjournal.Dream_journal_api.repository;

import com.dreamjournal.Dream_journal_api.dto.response.DreamResponse;
import com.dreamjournal.Dream_journal_api.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DreamRepository extends JpaRepository<Dream,Long> {
    List<Dream> findByUserId(Long userId);
}
