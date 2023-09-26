package br.com.matheus.spring_desafio.repository;

import br.com.matheus.spring_desafio.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
