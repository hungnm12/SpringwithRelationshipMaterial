package com.example.customer.Service;

import com.example.customer.Entity.Course;
import com.example.customer.Entity.Customer;
import com.example.customer.Repository.CourseRepo;
import com.example.customer.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CourseRepo courseRepo;


    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer createCustomer(Customer customer) {

        return customerRepo.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails)  {
        if (customerRepo.existsById(id)) {
            Customer customer = customerRepo.getById(id);

            customer.setAddress(customerDetails.getAddress());
            customer.setFullName(customerDetails.getFullName());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            customer.setCourses(customerDetails.getCourses());
            customerRepo.save(customer);
        }
        else {
            System.out.println("Customer Id not found");
        }
        return null;
    }


    public boolean deleteCustomer(int id) {
        if (customerRepo.existsById(id)) {
                customerRepo.deleteById(id);
        }
        else{
            System.out.println("Customer Id not found");
        }
        return true;
    }


    public Customer addCourseToCustomer(int id, int courseid) {
        if (customerRepo.existsById(id)) {
            Customer customer = customerRepo.getById(id);
            if (courseRepo.existsById(courseid)) {
                Course course = courseRepo.getById(courseid);
                customer.getCourses().add(course);
                return customerRepo.save(customer);
            }
            else {
                System.out.println("Course not found");
            }
        } else {
            System.out.println("Customer Id not found ");

        }
        return null;
    }

}
