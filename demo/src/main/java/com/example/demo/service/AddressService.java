package com.example.demo.service;


import com.example.demo.entity.CustAdr;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class AddressService {
    @Autowired
    AddressRepository repository;


    public List<CustAdr> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Optional<CustAdr> getById(long id) {
        Optional<CustAdr> byId = repository.findById(id);
        if (byId.isPresent())
            System.out.println("Address fetched successfully : " + byId.get());
        else
            System.out.println("Address Not found");
        return byId;
    }



    public List<CustAdr> findByCountryStartingWith(String countryPrefix){
        List<CustAdr> list = repository.findByCountryStartingWith(countryPrefix);
        System.out.println("Addresses fetched with country name begin with  given prefix");
        list.forEach(System.out::println);
        return list;
    }



}
