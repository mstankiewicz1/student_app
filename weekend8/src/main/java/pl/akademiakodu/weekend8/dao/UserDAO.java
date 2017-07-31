package pl.akademiakodu.weekend8.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.weekend8.entity.User;

/**
 * Created by itml on 11.06.2017.
 */
@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :username")
    User loadUserByUsername(@Param("username") String username);
}
