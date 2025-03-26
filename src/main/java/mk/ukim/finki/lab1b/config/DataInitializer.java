package mk.ukim.finki.lab1b.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Enumerations.Category;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.repository.CountryRepository;
import mk.ukim.finki.lab1b.repository.HostRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AccommodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
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


        Accommodation acc1 = accommodationRepository.save(new Accommodation("Manoli's", Category.HOTEL,host1,67,false));
        Accommodation acc2 = accommodationRepository.save(new Accommodation("Fishy", Category.APARTMENT,host2,3,true));
        Accommodation acc3 = accommodationRepository.save(new Accommodation("Moni's", Category.FLAT,host3,2,false));
        Accommodation acc4 = accommodationRepository.save(new Accommodation("Tagora's", Category.MOTEL,host4,90,false));

        accommodationRepository.save(acc1);
        accommodationRepository.save(acc2);
        accommodationRepository.save(acc3);
        accommodationRepository.save(acc4);
    }
}
