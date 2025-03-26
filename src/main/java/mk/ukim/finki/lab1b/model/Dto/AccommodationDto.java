package mk.ukim.finki.lab1b.model.Dto;

import lombok.Data;
import mk.ukim.finki.lab1b.model.Enumerations.Category;

@Data
public class AccommodationDto {

    private String name;

    private Category category;

    private Long host;

    private Integer numRooms;

    private Boolean markRented;

    public AccommodationDto() {
    }

    public AccommodationDto(String name, Category category, Long host, Integer numRooms, Boolean markRented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.markRented = markRented;
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

    public Boolean getMarkRented() {
        return markRented;
    }

    public void setMarkRented(Boolean markRented) {
        this.markRented = markRented;
    }
}
