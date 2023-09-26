package br.com.matheus.spring_desafio.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.matheus.spring_desafio.dto.CreateAddressDto;
import br.com.matheus.spring_desafio.exception.AppException;
import br.com.matheus.spring_desafio.model.Address;
import br.com.matheus.spring_desafio.repository.AddressRepository;
import br.com.matheus.spring_desafio.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(final CreateAddressDto addressData) {
        final Address newAddress = new Address(addressData.getStreet(), addressData.getNumber(),
                addressData.getZipCode(), addressData.getCity());

        return addressRepository.save(newAddress);
    }

    public Address retrieveAddress(final long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AppException("addressNotFound", HttpStatus.NOT_FOUND));
    }
}
