package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.model.Enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

}
