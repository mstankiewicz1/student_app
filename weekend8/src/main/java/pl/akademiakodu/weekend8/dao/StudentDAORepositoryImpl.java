package pl.akademiakodu.weekend8.dao;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.weekend8.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by itml on 28.05.2017.
 */
@Repository
@Transactional
public class StudentDAORepositoryImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery(
                "SELECT s FROM Student s LEFT JOIN s.studentDetails");
        List<Student> resultList = (List<Student>) query.getResultList();
        return resultList;
    }

    @Override
    public void persist(Student student) {
        entityManager.persist(student);
    }

    @Override
    public boolean hasEntry(Student student) {
        final String HQL = "SELECT s FROM Student s WHERE s.name = :name AND s.surname = :surname";
        Query query = entityManager.createQuery(HQL);
        query.setParameter("name", student.getName());
        query.setParameter("surname", student.getSurname());
        List resultList = query.getResultList();
        return resultList.size() > 0;
    }

    @Override
    public void remove(long id) {
        Student byId = findById(id);
        entityManager.remove(byId);
    }

    @Override
    public void merge(Student student) {
        entityManager.merge(student);
    }
}
