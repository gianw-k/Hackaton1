package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private int maxRequestsPerWindow;
    private int maxTokensPerWindow;
    private int windowInMinutes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
