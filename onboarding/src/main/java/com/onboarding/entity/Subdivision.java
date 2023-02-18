package com.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    private String name;
    @OneToMany(mappedBy = "subdivision")
    private List<User> user;

    //public Subdivision(Set<User> user) {
       // this.user = user;
    //}
}
