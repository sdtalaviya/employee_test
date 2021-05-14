package com.paypal.bfs.test.employeeserv.api.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Address")
@Table
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "address")
    private EmployeeEntity employee;

    private String line1;

    @Basic(optional = true)
    @Column(nullable = true)
    private String line2;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AddressEntity that = (AddressEntity) o;
        return line1.equals(that.line1) &&
                Objects.equals(line2, that.line2) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                country.equals(that.country) &&
                zipCode.equals(that.zipCode);
    }

    @Override public int hashCode() {
        return Objects.hash(line1, line2, city, state, country, zipCode);
    }
}
