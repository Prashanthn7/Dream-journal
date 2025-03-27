package com.dreamjournal.Dream_journal_api.repository;

import com.dreamjournal.Dream_journal_api.model.CareerSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<CareerSuggestion,Long> {
    List<CareerSuggestion> findByUser_Id(Long userId);
}
