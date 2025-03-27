package com.dreamjournal.Dream_journal_api.model;

import jakarta.persistence.*;
import lombok.Getter;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name ="suggested_career")
    private String suggestedCareer;

    @Column(name="confidence_score")
    private double confidenceScore;

    @Column(name = "courses")
    private String courses;
}
