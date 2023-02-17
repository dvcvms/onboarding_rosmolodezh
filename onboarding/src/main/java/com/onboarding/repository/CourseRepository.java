package com.onboarding.repository;

import com.onboarding.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Course findCourseById(long courseId);

    Course save(Course course);

}
