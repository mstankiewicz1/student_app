package pl.akademiakodu.weekend8.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.weekend8.entity.Role;

/**
 * Created by itml on 11.06.2017.
 */
@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {
}
