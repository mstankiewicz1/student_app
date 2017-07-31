package pl.akademiakodu.weekend8.service;

import pl.akademiakodu.weekend8.entity.Student;

import java.util.List;

/**
 * Created by itml on 27.05.2017.
 */
public interface StudentService {
    Student get(long id);
    List<Student> findAll();
    boolean save(Student student);
    void delete(long id);
    List<Student> findByCity(String city);
}
