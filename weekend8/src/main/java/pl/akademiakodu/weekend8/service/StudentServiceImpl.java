package pl.akademiakodu.weekend8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.weekend8.dao.StudentDAO;
import pl.akademiakodu.weekend8.entity.Student;

import java.util.List;

/**
 * Created by itml on 27.05.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAORepositoryImpl;

    @Override
    public Student get(long id) {
        Student studentById = studentDAORepositoryImpl.findById(id);
        if (studentById == null) {
            throw new IllegalArgumentException("Student not found");
        } else {
            return studentById;
        }
    }

    @Override
    public List<Student> findAll() {
        return studentDAORepositoryImpl.findAll();
    }

    @Override
    public boolean save(Student student) {
        System.out.println(student);
        if (student.getId() != null) {
            studentDAORepositoryImpl.merge(student);
            return true;
        } else {
            boolean exists = studentDAORepositoryImpl.hasEntry(student);
            if (exists) {
                return false;
            } else {
                studentDAORepositoryImpl.persist(student);
                return true;
            }
        }
    }

    @Override
    public void delete(long id) {
        studentDAORepositoryImpl.remove(id);
    }

    @Override
    public List<Student> findByCity(String city) {
        return null;
    }
}
