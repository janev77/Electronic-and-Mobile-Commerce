package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateUserDto;
import mk.ukim.finki.lab1b.dto.DisplayUserDto;
import mk.ukim.finki.lab1b.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);


}
