package mk.ukim.finki.lab1b.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Enumerations.Category;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.model.Reservation;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.repository.CountryRepository;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;
    private final ReservationRepository reservationRepository;

    public DataInitializer(AccommodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository, ReservationRepository reservationRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
        this.reservationRepository = reservationRepository;
    }


    @PostConstruct
    public void init() {

        Country aegean = countryRepository.save(new Country("Aegean Macedonia","Europe"));
        Country macedonia = countryRepository.save(new Country("Macedonia","Europe"));
        Country america = countryRepository.save(new Country("California","America"));
        Country australia = countryRepository.save(new Country("Canberra","Australia"));

        countryRepository.save(aegean);
        countryRepository.save(macedonia);
        countryRepository.save(america);
        countryRepository.save(australia);


        Host host1 = hostRepository.save(new Host("Manoli","Manolevski",aegean));
        Host host2 = hostRepository.save(new Host("Aleksandar","Janev",macedonia));
        Host host3 = hostRepository.save(new Host("John","Doe",america));
        Host host4 = hostRepository.save(new Host("Billy","Jones",australia));

        hostRepository.save(host1);
        hostRepository.save(host2);
        hostRepository.save(host3);
        hostRepository.save(host4);


        Accommodation acc1 = accommodationRepository.save(new Accommodation("Manoli's", Category.HOTEL,host1,67));
        Accommodation acc2 = accommodationRepository.save(new Accommodation("Fishy", Category.APARTMENT,host2,3));
        Accommodation acc3 = accommodationRepository.save(new Accommodation("Moni's", Category.FLAT,host3,2));
        Accommodation acc4 = accommodationRepository.save(new Accommodation("Tagora's", Category.MOTEL,host4,90));

        accommodationRepository.save(acc1);
        accommodationRepository.save(acc2);
        accommodationRepository.save(acc3);
        accommodationRepository.save(acc4);


        Reservation res1 = reservationRepository.save(new Reservation("1213", LocalDate.now(),LocalDate.now(),2,500,acc1));
        Reservation res2 = reservationRepository.save(new Reservation("1214",LocalDate.now(),LocalDate.now(),2,500,acc2));
        Reservation res3 = reservationRepository.save(new Reservation("1253",LocalDate.now(),LocalDate.now(),2,500,acc3));

        reservationRepository.save(res1);
        reservationRepository.save(res2);
        reservationRepository.save(res3);
    }
}
