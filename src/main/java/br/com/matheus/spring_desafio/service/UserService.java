package br.com.matheus.spring_desafio.service;

import java.util.List;

import br.com.matheus.spring_desafio.dto.UserDto;
import br.com.matheus.spring_desafio.model.User;

public interface UserService {
    User createUser(final UserDto userData);

    List<User> readUsers();

    User retrieveUser(final long id);

    User updateUser(final UserDto userData, final long id);

    void deleteUser(final long id);
}
