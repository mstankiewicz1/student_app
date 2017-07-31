package pl.akademiakodu.weekend8.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.akademiakodu.weekend8.entity.Student;

import static org.junit.Assert.*;

/**
 * Created by itml on 10.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentDAOSpringDatoRepoImplTest {

    @Autowired
    private StudentDAOSpringDatoRepoImpl studentDAOSpringDatoRepoImpl;

    @Test
    public void findByPESEL() throws Exception {
        Student one = studentDAOSpringDatoRepoImpl.findByPESEL("12332200987");
        System.out.println(one);
        assertEquals("12332200987", one.getStudentDetails().getPesel());
    }
}