package br.com.matheus.spring_desafio.service;

import br.com.matheus.spring_desafio.dto.CreateAddressDto;
import br.com.matheus.spring_desafio.model.Address;

public interface AddressService {

    public Address createAddress(final CreateAddressDto addressData);

    public Address retrieveAddress(final long id);

}
