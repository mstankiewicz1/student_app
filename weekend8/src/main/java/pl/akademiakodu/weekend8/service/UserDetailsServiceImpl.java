package pl.akademiakodu.weekend8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.akademiakodu.weekend8.dao.UserDAO;
import pl.akademiakodu.weekend8.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by itml on 11.06.2017.
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.loadUserByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        user.getRoles().forEach( (r) -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                grantedAuthorities);

    }
}
