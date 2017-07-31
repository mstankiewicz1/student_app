package pl.akademiakodu.weekend8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akademiakodu.weekend8.dao.CourseDAOCrudImpl;
import pl.akademiakodu.weekend8.dao.StudentDAOSpringDatoRepoImpl;
import pl.akademiakodu.weekend8.entity.Course;
import pl.akademiakodu.weekend8.entity.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by itml on 10.06.2017.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAOCrudImpl courseDAOCrudImpl;

    @Autowired
    private StudentDAOSpringDatoRepoImpl studentDAOSpringDatoRepoImpl;


    @Override
    public Set<Course> findAll() {
        Iterable<Course> all = courseDAOCrudImpl.findAll();
        Set<Course> courses = new HashSet<>();
        all.forEach(courses::add);
        return courses;
    }

    @Override
    public void enroll(Long courseId, Long studentId) {
        Course course = courseDAOCrudImpl.findOne(courseId);
        Student student = studentDAOSpringDatoRepoImpl.findOne(studentId);

        System.out.println(course);
        System.out.println(student);

        student.getCourses().add(course);

        studentDAOSpringDatoRepoImpl.save(student);
    }
}
