package com.example.demo.controller;

import com.example.demo.service.AddressService;
import com.example.demo.service.DTO.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin("*")
@RequiredArgsConstructor

public class AddressController {

    private final AddressService addressService;

    @GetMapping("/all")
    public List<AddressDTO> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/{id}")
    public AddressDTO getAddress(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/create")
    public AddressDTO createAddress(@RequestBody AddressDTO address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/update/{id}")
    public AddressDTO updateAddress (@PathVariable Integer id, @RequestBody AddressDTO address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}







