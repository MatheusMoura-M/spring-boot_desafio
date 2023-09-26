package br.com.matheus.spring_desafio.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.matheus.spring_desafio.dto.UserDto;
import br.com.matheus.spring_desafio.exception.AppException;
import br.com.matheus.spring_desafio.model.Address;
import br.com.matheus.spring_desafio.model.User;
import br.com.matheus.spring_desafio.repository.AddressRepository;
import br.com.matheus.spring_desafio.repository.UserRepository;
import br.com.matheus.spring_desafio.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;

    }

    public User createUser(final UserDto userData) {

        final Address foundAddress = addressRepository.findById(userData.getAddress_id())
                .orElseThrow(() -> new AppException("addressNotFound", HttpStatus.NOT_FOUND));

        System.out.println(foundAddress);

        final User newUser = new User(userData.getName(), userData.getBirthday(),
                foundAddress);

        return userRepository.save(newUser);
    }

    public List<User> readUsers() {
        return userRepository.findAll();
    }

    public User retrieveUser(final long id) {
        return userRepository.findById(id).orElseThrow(() -> new AppException("userNotFound", HttpStatus.NOT_FOUND));
    }

    public User updateUser(final UserDto userData, final long id) {

        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("userNotFound", HttpStatus.NOT_FOUND));

        foundUser.setName(userData.getName());
        foundUser.setBirthday(userData.getBirthday());

        return userRepository.save(foundUser);
    }

    public void deleteUser(final long id) {

        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("userNotFound", HttpStatus.NOT_FOUND));

        userRepository.delete(foundUser);
    }
}
