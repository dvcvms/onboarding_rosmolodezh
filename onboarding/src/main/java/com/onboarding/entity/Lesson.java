package com.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materials; // TODO: check

    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "lesson")
    List<QuestionEntity> questions;
}
