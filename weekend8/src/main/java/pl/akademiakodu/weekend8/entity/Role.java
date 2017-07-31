package pl.akademiakodu.weekend8.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by itml on 11.06.2017.
 */
@Entity
@Table(name = "ROLE",
        uniqueConstraints = {
                @UniqueConstraint(name = "ROLE_UNIQUE_CNSTR", columnNames = "NAME")
        })
public class Role extends AbstractPersistable<Long> {

    @Column(name = "NAME", unique = true)
    @NotEmpty
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
