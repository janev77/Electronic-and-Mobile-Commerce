package mk.ukim.finki.lab1b.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1b.repository.AccommodationPerHostViewRepository;
import mk.ukim.finki.lab1b.repository.HostPerCountryViewRepository;
import org.springframework.stereotype.Component;

@Component
public class MaterializedViewRefresher {
    private final AccommodationPerHostViewRepository accommodationPerHostViewRepository;
    private final HostPerCountryViewRepository hostPerCountryViewRepository;
    public MaterializedViewRefresher(AccommodationPerHostViewRepository accommodationPerHostViewRepository, HostPerCountryViewRepository hostPerCountryViewRepository) {
        this.accommodationPerHostViewRepository = accommodationPerHostViewRepository;
        this.hostPerCountryViewRepository = hostPerCountryViewRepository;
    }

    @PostConstruct
    public void init() {
        accommodationPerHostViewRepository.refreshMaterializedView();
        hostPerCountryViewRepository.refreshMaterializedView();
    }
}
