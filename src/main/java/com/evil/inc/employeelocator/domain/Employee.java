package com.evil.inc.employeelocator.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    @Embedded
    private Address address;

    @Embedded
    private GeoLocation geoLocation;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private JobPosition jobPosition;

    private boolean geoProcessed = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;
        return this.id != null && that.id.equals(this.id);
    }

    public String getFullName() {
        return firstName + ", " + lastName;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}