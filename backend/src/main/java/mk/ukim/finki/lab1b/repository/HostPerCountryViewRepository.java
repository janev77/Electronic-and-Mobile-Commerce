package mk.ukim.finki.lab1b.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.lab1b.model.Views.HostPerCountryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HostPerCountryViewRepository extends JpaRepository<HostPerCountryView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.host_per_country",nativeQuery = true)
    void refreshMaterializedView();
}
