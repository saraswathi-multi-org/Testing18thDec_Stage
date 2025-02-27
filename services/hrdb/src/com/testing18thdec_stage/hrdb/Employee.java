/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.hrdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Employee generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`EMPLOYEE`")
public class Employee implements Serializable {

    private Integer empId;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Date birthdate;
    private String picurl;
    private String jobTitle;
    private Integer deptId;
    private String username;
    private String password;
    private String role;
    private Integer managerId;
    private Integer tenantId;
    private Department department;
    private Employee employeeByManagerId;
    private List<Employee> employeesForManagerId;
    private List<Vacation> vacations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`EMP_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getEmpId() {
        return this.empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Column(name = "`FIRSTNAME`", nullable = true, length = 255)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "`LASTNAME`", nullable = true, length = 255)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "`STREET`", nullable = true, length = 255)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "`CITY`", nullable = true, length = 255)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "`STATE`", nullable = true, length = 2)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`ZIP`", nullable = true, length = 255)
    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name = "`BIRTHDATE`", nullable = true)
    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "`PICURL`", nullable = true, length = 255)
    public String getPicurl() {
        return this.picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Column(name = "`JOB_TITLE`", nullable = true, length = 40)
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Column(name = "`DEPT_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Column(name = "`USERNAME`", nullable = true, length = 255)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "`PASSWORD`", nullable = true, length = 255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`ROLE`", nullable = true, length = 255)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "`MANAGER_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getManagerId() {
        return this.managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Column(name = "`TENANT_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`DEPT_ID`", referencedColumnName = "`DEPT_ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`DEPTFKEY`"))
    @Fetch(FetchMode.JOIN)
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        if(department != null) {
            this.deptId = department.getDeptId();
        }

        this.department = department;
    }

    // ignoring self relation properties to avoid circular loops & unwanted fields from the related entity.
    @JsonIgnoreProperties({"employeeByManagerId", "employeesForManagerId"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`MANAGER_ID`", referencedColumnName = "`EMP_ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`MGRFKEY`"))
    @Fetch(FetchMode.JOIN)
    public Employee getEmployeeByManagerId() {
        return this.employeeByManagerId;
    }

    public void setEmployeeByManagerId(Employee employeeByManagerId) {
        if(employeeByManagerId != null) {
            this.managerId = employeeByManagerId.getEmpId();
        }

        this.employeeByManagerId = employeeByManagerId;
    }
    // ignoring self relation properties to avoid circular loops & unwanted fields from the related entity.
    @JsonIgnoreProperties({"employeeByManagerId", "employeesForManagerId"})
    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByManagerId")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<Employee> getEmployeesForManagerId() {
        return this.employeesForManagerId;
    }

    public void setEmployeesForManagerId(List<Employee> employeesForManagerId) {
        this.employeesForManagerId = employeesForManagerId;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public List<Vacation> getVacations() {
        return this.vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    @PostPersist
    public void onPostPersist() {
        if(employeesForManagerId != null) {
            employeesForManagerId.forEach(_employee -> _employee.setEmployeeByManagerId(this));
        }
        if(vacations != null) {
            vacations.forEach(_vacation -> _vacation.setEmployee(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(getEmpId(), employee.getEmpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId());
    }
}