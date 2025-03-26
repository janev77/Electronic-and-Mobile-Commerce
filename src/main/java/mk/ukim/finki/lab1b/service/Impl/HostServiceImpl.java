package mk.ukim.finki.lab1b.service.Impl;

import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> save(Host host) {
        return Optional.empty();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
