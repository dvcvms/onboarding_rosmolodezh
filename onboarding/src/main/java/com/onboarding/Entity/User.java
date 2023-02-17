package com.onboarding.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @OneToOne
    private Status status;
    private String name;
//    private Long subdivisionId;
    private Long statusId;

    public User(Long statusId) {
        this.statusId = statusId;
    }
}
