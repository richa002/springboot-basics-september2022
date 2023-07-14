package com.example.demo.service;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    @Transactional
    public void save(Customer customer) {
        repository.save(customer);
        System.out.println("Customer saved successfully");
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Optional<Customer> getById(long id) {
        Optional<Customer> byId = repository.findById(id);
        if (byId.isPresent())
            System.out.println("Customer fetched successfully : " + byId.get());
        else
            System.out.println("Not found");
        return byId;
    }


    public void deleteById(long id) {
        repository.deleteById(id);
        System.out.println("customer deleted successfully");
    }

    public void findCustomerByFirstName(String name){
        List<Customer> list = repository.findByFirstName("richa");
        list.forEach(System.out::println);
    }


    public Optional<Customer> updateProfile(long id, Customer customer) {

        Optional<Customer> byId = repository.findById(id);

        if(byId.isPresent()){
            Customer c = byId.get();
            c.setPassword(customer.getPassword());
            c.setUser_name(customer.getUser_name());
            c.setCustAdr(customer.getCustAdr());
            c.setEmail(customer.getEmail());
            c.setFirstName(customer.getFirstName());
            c.setLastName(customer.getLastName());
           return Optional.of(repository.save(c));
        }
        return Optional.empty();
    }


}
