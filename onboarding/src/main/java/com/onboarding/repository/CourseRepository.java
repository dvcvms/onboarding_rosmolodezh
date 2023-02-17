package com.onboarding.repository;

import com.onboarding.entity.Course;
import com.onboarding.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Course findCourseById(long courseId);
    Course save(Course course);

}
