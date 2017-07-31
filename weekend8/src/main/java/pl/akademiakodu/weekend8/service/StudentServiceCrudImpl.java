package pl.akademiakodu.weekend8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pl.akademiakodu.weekend8.dao.StudentDAOSpringDatoRepoImpl;
import pl.akademiakodu.weekend8.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itml on 10.06.2017.
 */
@Service
public class StudentServiceCrudImpl implements StudentService {

    @Autowired
    private StudentDAOSpringDatoRepoImpl studentDAOSpringDatoRepoImpl;


    @Override
    public Student get(long id) {
        Student studentById = studentDAOSpringDatoRepoImpl.findOne(id);
        if (studentById == null) {
            throw new IllegalArgumentException("Student not found");
        } else {
            return studentById;
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Override
    public List<Student> findAll() {
        Iterable<Student> iterable = studentDAOSpringDatoRepoImpl.findAll();
        List<Student> target = new ArrayList<>();
        iterable.forEach(target::add);
        return target;
    }

    @Override
    public boolean save(Student student) {
        studentDAOSpringDatoRepoImpl.save(student);
        return true;
    }

    @Override
    public void delete(long id) {
        studentDAOSpringDatoRepoImpl.delete(id);
    }

    public List<Student> findByCity(String city) {
        return (List<Student>) studentDAOSpringDatoRepoImpl.findByCity(city);
    }
}
