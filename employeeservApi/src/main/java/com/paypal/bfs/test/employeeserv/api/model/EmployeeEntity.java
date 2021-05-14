package com.paypal.bfs.test.employeeserv.api.model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    private int id;

    private String firstName;

    private String lastName;

    private int dobDay;

    private int dobMonth;

    private int dobYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    public EmployeeEntity() {
        super();
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public int getDobDay() {
        return dobDay;
    }

    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    public int getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return dobDay == that.dobDay &&
                dobMonth == that.dobMonth &&
                dobYear == that.dobYear &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                address.equals(that.address);
    }

    @Override public int hashCode() {
        return Objects.hash(firstName, lastName, dobDay, dobMonth, dobYear, address);
    }
}
