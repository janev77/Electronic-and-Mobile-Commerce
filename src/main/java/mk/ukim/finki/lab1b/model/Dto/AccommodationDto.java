package mk.ukim.finki.lab1b.model.Dto;

import lombok.Data;
import mk.ukim.finki.lab1b.model.Enumerations.Category;

@Data
public class AccommodationDto {

    private String name;

    private Category category;

    private Long host;

    private Integer numRooms;

    private Long reservation;

    public AccommodationDto() {
    }

    public AccommodationDto(String name, Category category, Long host, Integer numRooms, Long reservation) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.reservation = reservation;
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

    public Long getHost() {
        return host;
    }

    public void setHost(Long host) {
        this.host = host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Long getReservation() {
        return reservation;
    }

    public void setReservation(Long reservation) {
        this.reservation = reservation;
    }
}
