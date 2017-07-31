package pl.akademiakodu.weekend8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.akademiakodu.weekend8.entity.Student;
import pl.akademiakodu.weekend8.service.StudentService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Weekend8ApplicationTests {

    @Autowired
    StudentService studentServiceImpl;

    @Test
    public void hasOneStudentInService() {
        List<Student> list = studentServiceImpl.findAll();
        assertEquals(1, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionOnNotExistingStudent() {
        Student student = studentServiceImpl.get(-1L);
        assertNull(student);
    }
}
