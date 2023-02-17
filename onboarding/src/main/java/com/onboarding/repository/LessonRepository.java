package com.onboarding.repository;

import com.onboarding.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findLessonById(long lessonId);
    List<Lesson> findAllByCourseId(long courseId);
    Lesson save(Lesson lesson);
}
