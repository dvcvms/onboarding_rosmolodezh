package com.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;


@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="answers")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name="question_id")
    private QuestionEntity question;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false, updatable = false)
    private User author;

}
