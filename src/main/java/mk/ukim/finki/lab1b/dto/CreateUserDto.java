package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.model.Enumerations.Role;

public record CreateUserDto(String username,
                            String password,
                            String repeatPassword,
                            String firstName,
                            String lastName,
                            Role role) {


    /*
        todo: add repeat password logic
     */


    public User toUser() {
        return new User(username, password, firstName, lastName, role);
    }

}
