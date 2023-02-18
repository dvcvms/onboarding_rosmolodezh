package com.onboarding.repository;

import com.onboarding.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    List<Lesson> findAll();

    Lesson findLessonById(long lessonId);

    List<Lesson> findLessonsByCourseId(long courseId);

    Lesson save(Lesson lesson);
}
