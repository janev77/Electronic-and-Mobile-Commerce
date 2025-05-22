package mk.ukim.finki.lab1b.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.lab1b.model.Views.AccommodationPerHostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccommodationPerHostViewRepository extends JpaRepository<AccommodationPerHostView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.accommodation_per_host",nativeQuery = true)
    void refreshMaterializedView();
}
