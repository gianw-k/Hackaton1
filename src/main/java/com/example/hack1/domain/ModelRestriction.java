package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelRestriction {
    @Id
    @GeneratedValue

    private Long id;

    private String modelName;
    private int maxRequests;
    private int maxTokens;
    private int windowInMinutes;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
