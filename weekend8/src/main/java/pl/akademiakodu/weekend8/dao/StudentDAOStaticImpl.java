package pl.akademiakodu.weekend8.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.weekend8.entity.Student;

import java.util.*;

/**
 * Created by itml on 27.05.2017.
 */
@Repository
public class StudentDAOStaticImpl implements StudentDAO {

    private static final Map<Long, Student> students = new HashMap<>();

    static {
        students.clear();
        students.put(1L, new Student(1L, "John", "Doe"));
        students.put(2L, new Student(2L, "Alice", "Boo"));
        students.put(3L, new Student(3L, "Andrew", "Catman"));
    }

    public StudentDAOStaticImpl() {
    }

    @Override
    public Student findById(long id) {
        return students.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    public boolean hasEntry(Student student) {
        for (Student s : students.values()) {
            if (s.getName().equals(student.getName()) && s.getSurname().equals(student.getSurname())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(long id) {
        students.remove(id);
    }

    @Override
    public void merge(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void persist(Student student) {
        List<Long> list = new ArrayList<>(students.keySet());
        Collections.sort(list);

        Long lastKey = list.get(list.size() - 1);
        long newKey = ++lastKey;

        //student.setId(newKey);
        students.put(newKey, student);
    }
}
