package pl.akademiakodu.weekend8.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by itml on 10.06.2017.
 */
@Table(
        name = "COURSE",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"NAME", "DATE_FROM", "DATE_TO", "PRICE", "CAPACITY"},
                        name = "CRS_UNQ_COLS_CONSTRT"
                )
        }
)
@Entity
public class Course extends AbstractPersistable<Long> {

    @Column(name = "NAME", nullable = false)
    @NotEmpty
    @NotNull
    private String name;

    @Column(name = "DATE_FROM", nullable = false)
    @NotNull
    private LocalDate from;

    @Column(name = "DATE_TO", nullable = false)
    @NotNull
    private LocalDate to;

    @Column(name = "PRICE", columnDefinition = "NUMBER(10,2)", nullable = false)
    @NotNull
    private BigDecimal price;

    @Column(name = "CAPACITY", nullable = false)
    private int capacity;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Course() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
