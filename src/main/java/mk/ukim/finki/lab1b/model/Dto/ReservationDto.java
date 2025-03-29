package mk.ukim.finki.lab1b.model.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationDto {

    private String code;

    private LocalDate start_date;

    private LocalDate end_date;

    private Integer numOfGuests;

    private Integer price;

    private Long accommodation;

    public ReservationDto() {
    }

    public ReservationDto(String code, LocalDate start_date, LocalDate end_date, int numOfGuests, Integer price, Long accommodation) {
        this.code = code;
        this.start_date = start_date;
        this.end_date = end_date;
        this.numOfGuests = numOfGuests;
        this.price = price;
        this.accommodation = accommodation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Integer getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(Integer numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Long accommodation) {
        this.accommodation = accommodation;
    }
}
