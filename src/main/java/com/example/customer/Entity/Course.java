package com.example.customer.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "courses")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;
    @Column(name = "course_name")
    private String courseName;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    private List<Customer> customers = new ArrayList<>();

    public Course() {
    }

    public Course(int courseid, String courseName, String description, List<Customer> customers) {
        this.courseid = courseid;
        this.courseName = courseName;
        this.description = description;
        this.customers = customers;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return"Course{" +
                "courseid=" + courseid +
                ", coursename='" + courseName + '\'' +
                ", description='" + description + '\'' +

                ", customer='" + customers +
                '}';
    }
}
