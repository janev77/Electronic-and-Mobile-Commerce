package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.model.Enumerations.Role;

public record DisplayUserDto(String username, String firstName, String lastname, Role role) {

    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getUsername(),
                user.getFirstName(),
                user.getLastname(),
                user.getRole()
        );
    }

    public User toUser() {
        return new User(username, firstName, lastname, role.name());
    }
}
