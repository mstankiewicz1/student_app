package pl.akademiakodu.weekend8.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Created by itml on 27.05.2017.
 */
@Table(name = "STUDENT",
        uniqueConstraints = @UniqueConstraint(
                name = "NAME_SURNAME_CSRT",
                columnNames = {"NAME", "SURNAME"})
)
@Entity
public class Student extends AbstractPersistable<Long> {

    @Column(name = "NAME", nullable = false)
    @NotNull
    @NotEmpty(message = "Pole imię nie może być puste")
    @Size(min = 3, message = "Wymagane min. 3 znaki")
    @Pattern(regexp = "[a-zA-Z]+", message = "Wymagane tylko litery")
    private String name;

    @Column(name = "SURNAME", nullable = false)
    @NotNull
    @NotEmpty(message = "Pole nazwisko nie może być puste")
    @Size(min = 3, message = "Wymagane min. 3 znaki")
    @Pattern(regexp = "[a-zA-Z]+", message = "Wymagane tylko litery")
    private String surname;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StudentDetails studentDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Book> books;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSES",
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
            }
    )
    private Set<Course> courses;

    public Student() {
    }

    public Student(Long id, String name, String surname) {
        this.setId(id);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return surname != null ? surname.equals(student.surname) : student.surname == null;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentDetails=" + studentDetails +
                ", address=" + address +
                '}';
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}