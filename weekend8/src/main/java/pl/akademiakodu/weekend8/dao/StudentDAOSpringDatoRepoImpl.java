package pl.akademiakodu.weekend8.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.akademiakodu.weekend8.entity.Student;

/**
 * Created by itml on 10.06.2017.
 */
public interface StudentDAOSpringDatoRepoImpl extends CrudRepository<Student, Long> {

    @Query("select s from Student s where s.studentDetails.pesel = :pesel")
    Student findByPESEL(@Param("pesel") String pesel);

    @Query("select s from Student s where s.address.city = :city")
    Iterable<Student> findByCity(@Param("city") String city);
}
