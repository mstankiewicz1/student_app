package pl.akademiakodu.weekend8.dao;

import pl.akademiakodu.weekend8.entity.Student;

import java.util.List;

/**
 * Created by itml on 27.05.2017.
 */
public interface StudentDAO {
    Student findById(long id);
    List<Student> findAll();
    void persist(Student student);
    boolean hasEntry(Student student);
    void remove(long id);
    void merge(Student student);
}
