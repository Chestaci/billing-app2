package ru.teapot.models;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    private String surname;
    @NotEmpty(message = "Date should not be empty")
    private String dateOfBirth;
    @NotEmpty(message = "Passport should not be empty")
    private String passportData;
    @NotEmpty(message = "Address should not be empty")
    private String address;
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @NotEmpty(message = "Password should not be empty")
    //@Email(message = "Email should be valid")
    private String password;

  //  private Set <Contract> contracts;
}
