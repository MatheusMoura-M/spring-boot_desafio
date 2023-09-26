package br.com.matheus.spring_desafio.repository;

import br.com.matheus.spring_desafio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
