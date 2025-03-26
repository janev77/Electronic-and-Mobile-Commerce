package mk.ukim.finki.lab1b.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab1b.model.Enumerations.Category;

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
    private Host host;

    private Integer numRooms;

    private Boolean markRented;

    public Accommodation() {
    }

    public Accommodation(String name, Category category, Host host, Integer numRooms, Boolean markRented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.markRented = markRented;
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

    public Boolean getMarkRented() {
        return markRented;
    }

    public void setMarkRented(Boolean markRented) {
        this.markRented = markRented;
    }
}
