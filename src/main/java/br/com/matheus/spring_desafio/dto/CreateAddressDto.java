package br.com.matheus.spring_desafio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAddressDto {
    @NotNull(message = "Street cannot be null")
    @Size(max = 100, message = "Street must be lower than 92 characters long")
    private String street;

    @NotNull(message = "Number cannot be null")
    @Size(max = 10, message = "Number must be lower than 92 characters long")
    private String number;

    @NotNull(message = "City cannot be null")
    @Size(max = 50, message = "City must be lower than 92 characters long")
    private String city;

    @NotNull(message = "ZipCode cannot be null")
    @Size(max = 15, message = "ZipCode must be lower than 92 characters long")
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
