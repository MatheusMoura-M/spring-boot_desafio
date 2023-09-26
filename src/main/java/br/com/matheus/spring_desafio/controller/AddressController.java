package br.com.matheus.spring_desafio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.spring_desafio.dto.CreateAddressDto;
import br.com.matheus.spring_desafio.model.Address;
import br.com.matheus.spring_desafio.service.AddressService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {
    final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(
            @Valid @RequestBody final CreateAddressDto addressData) {

        final Address createAddress = addressService.createAddress(addressData);

        return new ResponseEntity<>(createAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> retrieveAddress(@PathVariable final String id) {

        final Address address = addressService.retrieveAddress(Long.parseLong(id));

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
