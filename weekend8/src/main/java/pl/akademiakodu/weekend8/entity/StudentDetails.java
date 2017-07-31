package pl.akademiakodu.weekend8.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by itml on 28.05.2017.
 */
@Table(uniqueConstraints =
    @UniqueConstraint(name = "STUDENT_DET_PHONE_NO",
            columnNames = {"PHONE_NO", "PESEL"})
)
@Entity
public class StudentDetails extends AbstractPersistable<Long> {

    @Column(name = "PHONE_NO")
    @Size(min = 9, max = 9, message = "Numer telefonu musi mieć 9 cyfr")
    private String phoneNo;

    @Column(name = "PESEL")
    @Size(min = 11, max = 11, message = "Numer PESEL musi mieć 11 cyfr")
    private String pesel;

    public StudentDetails() {
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentDetails that = (StudentDetails) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        return pesel != null ? pesel.equals(that.pesel) : that.pesel == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + getId() +
                ", phoneNo='" + phoneNo + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
