package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.model.Projections.HostProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    List<HostProjection> findAllBy();
}
