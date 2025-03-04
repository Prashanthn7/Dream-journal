package com.dreamjournal.Dream_journal_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name ="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name ="username")
    private String username;

    @Column(name ="email")
    private String email;

    @Column(name= "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Dream> dreams;

}
