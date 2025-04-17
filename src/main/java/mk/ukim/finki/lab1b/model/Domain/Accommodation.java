package mk.ukim.finki.lab1b.model.Domain;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab1b.model.Enumerations.Category;

import java.util.List;

@Entity
@Data
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    private Integer numRooms;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

//    @OneToMany(mappedBy = "accommodation")
//    private List<Reservation> reservationList;

    boolean isReserved = false;


    public Accommodation() {
    }

    public Accommodation(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        //reservationList = new ArrayList<>();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    //    public List<Reservation> getReservationList() {
//        return reservationList;
//    }
//
//    public void setReservationList(List<Reservation> reservationList) {
//        this.reservationList = reservationList;
//    }
}



