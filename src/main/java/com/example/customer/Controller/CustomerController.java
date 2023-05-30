package com.example.customer.Controller;

import com.example.customer.Entity.Customer;
import com.example.customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/save")
    public Customer createCustomer(@RequestBody Customer customer) {
        return  customerService.createCustomer(customer);
    }
    @GetMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int id, @RequestBody Customer customerDetails) {
        final Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
        return ResponseEntity.ok(updatedCustomer);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        boolean deleteCustomer = customerService.deleteCustomer(id);
        return "deleted";
    }

    @PostMapping("/{id}/courses/{courseid}")
    public ResponseEntity<Customer> addCourseToCustomer(@PathVariable(value = "id") int id, @PathVariable(value = "courseid") int courseid){
        final Customer updatedCustomer = customerService.addCourseToCustomer(id, courseid);
        return ResponseEntity.ok(updatedCustomer);
    }
}
