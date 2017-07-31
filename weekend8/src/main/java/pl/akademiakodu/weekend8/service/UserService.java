package pl.akademiakodu.weekend8.service;

import pl.akademiakodu.weekend8.entity.User;

/**
 * Created by itml on 11.06.2017.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
