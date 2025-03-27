package com.dreamjournal.Dream_journal_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="dreams")
@Getter
@Setter
public class Dream {

    @Id
    @Column(name ="dream_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name ="dream_text")
    private String dreamText;

    @Column(name="recorded_at")
    private LocalDate recordedAt;

    @PrePersist
    public void prePersist(){

        this.recordedAt = LocalDate.now();
    }
}
