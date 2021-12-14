package com.example.ea_final_project.controller;

import com.example.ea_final_project.model.Address;
import com.example.ea_final_project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    AddressService service;

    @GetMapping
    public List<Address> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @PatchMapping("/{id}")
    public Address update(@PathVariable Integer id, @RequestBody Address address) {
        Address persistedAddress = service.findById(address.getId());
        if (persistedAddress != null) {
            persistedAddress.setStreet(address.getStreet());
            persistedAddress.setCity(address.getCity());
            persistedAddress.setPostalCode(address.getPostalCode());
           persistedAddress.setState(address.getState());
           persistedAddress.setCountry(address.getCountry());
            return service.update(persistedAddress);
        }
        return address;
    }
}
