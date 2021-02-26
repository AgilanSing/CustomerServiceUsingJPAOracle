package com.customerservice.controller;

import com.customerservice.entity.Customer;
import com.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cust")
public class CustomerController {
    @Autowired
    CustomerService custService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return this.custService.getAllCustomers();
    }


    @RequestMapping(value = "/addcust", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer addCustomer(@RequestBody Customer customer) {
        return this.custService.addCustomer(customer);
    }


    @RequestMapping(value = "/updatecust", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer updateCustomer(@RequestBody Customer customer) {
        return this.custService.updateCustomer(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustmomer(@PathVariable int id) {
        return this.custService.getCustomerById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        this.custService.deleteAllCustomers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id) {
        this.custService.deleteCustomerById(id);
    }

 
}
