package com.onboarding.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "subdivision")
@NoArgsConstructor
@AllArgsConstructor
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subdivisionId;
    @OneToMany
    private Set<User> user;

    public Subdivision(Set<User> user) {
        this.user = user;
    }
}
