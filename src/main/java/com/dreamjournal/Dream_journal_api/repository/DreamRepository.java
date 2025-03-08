package com.dreamjournal.Dream_journal_api.repository;

import com.dreamjournal.Dream_journal_api.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepository extends JpaRepository<Dream,Long> {
}
