package com.example.demo.service;

import com.example.demo.model.entity.Address;
import com.example.demo.repository.AddressRepo;
import com.example.demo.service.DTO.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;

    public List<AddressDTO> getAddresses() {
        return addressRepo.findAll()
                .stream()
                .map(AddressDTO::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO getAddressById(Integer id) {
        return addressRepo.findById(id)
                .map(AddressDTO::fromEntityToDTO)
                .orElse(null);
    }

    public AddressDTO saveAddress(AddressDTO dto) {

        dto.setId(null);
        Address address = Address.toEntity(dto);
        Address saved = addressRepo.save(address);
        return AddressDTO.fromEntityToDTO(saved);
    }

    public AddressDTO updateAddress(Integer id, AddressDTO dto) {
        Address existing = addressRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        existing.setCity(dto.getCity());
        existing.setStreetName(dto.getStreetName());
        existing.setZipCode(dto.getZipCode());
        Address updated = addressRepo.save(existing);
        return AddressDTO.fromEntityToDTO(updated);
    }


    public void deleteAddress(Integer id) {
        addressRepo.deleteById(id);
    }
}
