package pl.akademiakodu.weekend8.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;
import pl.akademiakodu.weekend8.validators.PasswordMatch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by itml on 11.06.2017.
 */
@Entity
@Table(name = "USER",
uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_USER_LOGIN_CNSTR", columnNames = {"LOGIN"})
})
@PasswordMatch(
        fieldName = "passwordConfirm",
        message = "Podane hasła są różne")
public class User extends AbstractPersistable<Long> {

    @Column(name = "LOGIN", unique = true)
    @NotEmpty(message = "Pole nie może być puste")
    @Size(min = 5, max = 10, message = "Pole musi zawierać min 5 znaków, max 10")
    private String login;

    @Column(name = "PASSWORD")
    @NotEmpty(message = "Pole nie może być puste")
    @NotNull
    @Size(min = 5, max = 100, message = "Pole musi zawierać min 5 znaków, max 100")
    private String password;

    @Transient
    @Size(min = 5, max = 100, message = "Pole musi zawierać min 5 znaków, max 100")
    @NotEmpty(message = "Pole nie może być puste")
    @NotNull
    private transient String passwordConfirm;

    @ManyToMany
    @JoinTable(name = "USER_ROLES",
            joinColumns = { @JoinColumn(name = "USER_ID")},
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID")}
    )
    private Set<Role> roles;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}
