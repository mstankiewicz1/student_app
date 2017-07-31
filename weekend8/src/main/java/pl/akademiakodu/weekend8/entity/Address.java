package pl.akademiakodu.weekend8.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by itml on 10.06.2017.
 */
@Table( name = "address")
@Entity
public class Address extends AbstractPersistable<Long> {

    @NotNull
    @NotEmpty(message = "Pole kod pocztowy nie może być puste")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Kod pocztowy musi być w formacie 00-000")
    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @NotNull
    @NotEmpty(message = "Pole miasto nie może być puste")
    @Column(name = "CITY", nullable = false)
    private String city;

    @NotNull
    @NotEmpty(message = "Pole ulica nie może być puste")
    @Column(name = "STREET_NAME", nullable = false)
    private String streetName;

    @NotNull
    @NotEmpty(message = "Pole numer ulicy nie może być puste")
    @Column(name = "STREET_NO", nullable = false)
    private String streetNo;

    @Column(name = "APART_NO")
    private String apartNo;

    @OneToOne
    private Student student;

    public Address() {
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getApartNo() {
        return apartNo;
    }

    public void setApartNo(String apartNo) {
        this.apartNo = apartNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getId() != null ? !getId().equals(address.getId()) : address.getId() != null) return false;
        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (streetName != null ? !streetName.equals(address.streetName) : address.streetName != null) return false;
        if (streetNo != null ? !streetNo.equals(address.streetNo) : address.streetNo != null) return false;
        if (apartNo != null ? !apartNo.equals(address.apartNo) : address.apartNo != null) return false;
        return student != null ? student.equals(address.student) : address.student == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (streetNo != null ? streetNo.hashCode() : 0);
        result = 31 * result + (apartNo != null ? apartNo.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + getId() +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", apartNo='" + apartNo + '\'' +
                ", student=" + student +
                '}';
    }
}
