package ru.teapot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.teapot.models.Client;

import java.util.List;

@Component
public class ClientDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static int PEOPLE_COUNT;
//    private List<Client> people;
//
//    {
//        people = new ArrayList<>();
//        people.add(new Client(++PEOPLE_COUNT, "Tom", "Cat", "21.01.1991",
//                "паспортные данные", "адресс", "tom@mail.ru", "пароль"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom2", "Cat2", "21.01.1992",
//                "паспортные данные2", "адресс2", "tom2@mail.ru", "пароль2"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom3", "Cat3", "21.01.1993",
//                "паспортные данные3", "адресс3", "tom3@mail.ru", "пароль3"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom4", "Cat4", "21.01.1994",
//                "паспортные данные4", "адресс4", "tom4@mail.ru", "пароль4"));
//        people.add(new Client(++PEOPLE_COUNT, "Tom5", "Cat5", "21.01.1995",
//                "паспортные данные5", "адресс5", "tom5@mail.ru", "пароль5"));
//
//    }

    public List<Client> index() {
        return jdbcTemplate.query("SELECT * FROM Client", new BeanPropertyRowMapper<>(Client.class));
    }

    public Client show(int id) {
        return jdbcTemplate.query("SELECT * FROM Client WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Client.class))
                .stream().findAny().orElse(null);
    }

    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO Client(name, surname, dateOfBirth, passportData, address, email, password) VALUES(?, ?, ?, ?, ?, ?, ?)", client.getName(), client.getSurname(), client.getDateOfBirth(),
                client.getPassportData(), client.getAddress(), client.getEmail(), client.getPassword());
    }

    public void update(int id, Client updatedClient) {
        jdbcTemplate.update("UPDATE Client SET name=?, surname=?, dateOfBirth=?, " +
                        "passportData=?, address=?, email=?, password=? WHERE id=?",
                updatedClient.getName(), updatedClient.getSurname(), updatedClient.getDateOfBirth(),
                updatedClient.getPassportData(), updatedClient.getAddress(), updatedClient.getEmail(), updatedClient.getPassword(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Client WHERE id=?", id);
    }
}
