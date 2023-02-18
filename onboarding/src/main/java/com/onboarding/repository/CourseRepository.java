package com.onboarding.repository;

import com.onboarding.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findAll();

    Course findCourseById(long courseId);

    Course save(Course course);

}
