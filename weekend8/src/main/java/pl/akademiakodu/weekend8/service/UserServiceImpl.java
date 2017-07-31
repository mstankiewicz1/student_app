package pl.akademiakodu.weekend8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.akademiakodu.weekend8.dao.RoleDAO;
import pl.akademiakodu.weekend8.dao.UserDAO;
import pl.akademiakodu.weekend8.entity.Role;
import pl.akademiakodu.weekend8.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by itml on 11.06.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Iterable<Role> all = roleDAO.findAll();
        Set<Role> roles = new HashSet<>();
        all.forEach(roles::add);
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.loadUserByUsername(username);
    }
}
