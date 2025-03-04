package com.dreamjournal.Dream_journal_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="career_suggestion")
@Getter
@Setter
public class CareerSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="career_id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name ="suggested_career")
    private String suggestedCareer;

    @Column(name="confidence_score")
    private double confidenceScore;
}
