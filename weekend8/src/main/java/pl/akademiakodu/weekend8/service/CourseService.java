package pl.akademiakodu.weekend8.service;

import pl.akademiakodu.weekend8.entity.Course;

import java.util.Set;

/**
 * Created by itml on 10.06.2017.
 */
public interface CourseService {
    Set<Course> findAll();
    void enroll(Long courseId, Long studentId);
}
