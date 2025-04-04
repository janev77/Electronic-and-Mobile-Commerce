package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Dto.HostDto;
import mk.ukim.finki.lab1b.model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {

    List<Host> findAll();

    Optional<Host> save(HostDto hostDto);

    Optional<Host> findById(Long id);

    Optional<Host> update(Long id, HostDto hostDto);

    void deleteById(Long id);

}
