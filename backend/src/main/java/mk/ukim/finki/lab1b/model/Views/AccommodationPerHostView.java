package mk.ukim.finki.lab1b.model.Views;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Subselect("SELECT * FROM accommodation_per_host")
@Immutable
public class AccommodationPerHostView {

    @Id
    @Column(name = "host_id")
    private Long hostId;

    @Column(name = "num_accommodations")
    private Long numAccommodations;

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getNumAccommodations() {
        return numAccommodations;
    }

    public void setNumAccommodations(Long numAccommodations) {
        this.numAccommodations = numAccommodations;
    }
}
