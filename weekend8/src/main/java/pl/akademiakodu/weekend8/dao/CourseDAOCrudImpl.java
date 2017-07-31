package pl.akademiakodu.weekend8.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.weekend8.entity.Course;

/**
 * Created by itml on 10.06.2017.
 */
@Repository
public interface CourseDAOCrudImpl extends CrudRepository<Course, Long> {
}
