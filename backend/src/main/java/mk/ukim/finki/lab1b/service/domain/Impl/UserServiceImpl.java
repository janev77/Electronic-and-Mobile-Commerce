package mk.ukim.finki.lab1b.service.domain.Impl;

import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.model.Exceptions.*;
import mk.ukim.finki.lab1b.repository.UserRepository;
import mk.ukim.finki.lab1b.security.JwtHelper;
import mk.ukim.finki.lab1b.service.domain.UserService;
import mk.ukim.finki.lab1b.model.Enumerations.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }



    @Override
    public User register(
            String username,
            String password,
            String repeatPassword,
            String firstName,
            String lastname,
            Role role
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword)) throw new PasswordsDoNotMatchException();
        if (userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, passwordEncoder.encode(password), firstName, lastname, role);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(InvalidUsernameOrPasswordException::new);

        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new InvalidArgumentsException();
        }

        return user;
    }


    @Override
    public User getAuthenticatedUser(String token) {
        String username = jwtHelper.extractUsername(token);
        return findByUsername(username);
    }
}