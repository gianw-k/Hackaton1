package com.example.hack1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ruc;
    private LocalDate registrationDate;
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private AppUser admin;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<AppUser> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ModelRestriction> restrictions;

}
