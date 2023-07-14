package com.example.demo.repository;

import com.example.demo.entity.CustAdr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository  extends JpaRepository<CustAdr,Long> {

    List<CustAdr> findByCountryAndCity(String country, String city);
    List<CustAdr> findByCountryIgnoreCase(String country);
    List<CustAdr> findByCityOrPincode(String city, String pincode);
    List<CustAdr> findTop2ByCountry(String country);
    List<CustAdr> findByCountryStartingWith(String substring);
    List<CustAdr> findByCountryContaining(String substring);

}
