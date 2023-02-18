package com.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @OneToOne
    private Subdivision subdivision;
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
            private List<Course> courses=new ArrayList<>();
    public void addCourse(Course course){
        this.courses.add(course);
        course.getUsers().add(this);
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
        course.getUsers().remove(this);
    }
    //private Long statusId;

    //public User(Long statusId) {
       // this.statusId = statusId;
    //}
}
