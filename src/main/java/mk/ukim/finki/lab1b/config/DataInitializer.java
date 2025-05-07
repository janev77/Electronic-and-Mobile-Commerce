//package mk.ukim.finki.lab1b.config;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.lab1b.model.Domain.*;
//import mk.ukim.finki.lab1b.model.Enumerations.Category;
//import mk.ukim.finki.lab1b.model.Enumerations.Role;
//import mk.ukim.finki.lab1b.repository.*;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
//@Component
//public class DataInitializer {
//
//    private final AccommodationRepository accommodationRepository;
//    private final HostRepository hostRepository;
//    private final CountryRepository countryRepository;
//    private final ReservationRepository reservationRepository;
//    private final UserRepository userRepository;
//
//    private final AccommodationPerHostViewRepository accommodationPerHostViewRepository;
//
//    private final TemporaryReservationRepository temporaryReservationRepository;
//
//
//    private final PasswordEncoder passwordEncoder;
//
//    public DataInitializer(AccommodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository, ReservationRepository reservationRepository, UserRepository userRepository, AccommodationPerHostViewRepository accommodationPerHostViewRepository, TemporaryReservationRepository temporaryReservationRepository, PasswordEncoder passwordEncoder) {
//        this.accommodationRepository = accommodationRepository;
//        this.hostRepository = hostRepository;
//        this.countryRepository = countryRepository;
//        this.reservationRepository = reservationRepository;
//        this.userRepository = userRepository;
//        this.accommodationPerHostViewRepository = accommodationPerHostViewRepository;
//        this.temporaryReservationRepository = temporaryReservationRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//
//    //@PostConstruct
//    public void init() {
//
//        Country aegean = countryRepository.save(new Country("Aegean Macedonia","Europe"));
//        Country macedonia = countryRepository.save(new Country("Macedonia","Europe"));
//        Country america = countryRepository.save(new Country("California","America"));
//        Country australia = countryRepository.save(new Country("Canberra","Australia"));
//
//        countryRepository.save(aegean);
//        countryRepository.save(macedonia);
//        countryRepository.save(america);
//        countryRepository.save(australia);
//
//
//        Host host1 = hostRepository.save(new Host("Manoli","Manolevski",aegean));
//        Host host2 = hostRepository.save(new Host("Aleksandar","Janev",macedonia));
//        Host host3 = hostRepository.save(new Host("John","Doe",america));
//        Host host4 = hostRepository.save(new Host("Billy","Jones",australia));
//
//        hostRepository.save(host1);
//        hostRepository.save(host2);
//        hostRepository.save(host3);
//        hostRepository.save(host4);
//
//
//        Accommodation acc1 = accommodationRepository.save(new Accommodation("Manoli's", Category.HOTEL,host1,3));
//        Accommodation acc2 = accommodationRepository.save(new Accommodation("Fishy", Category.APARTMENT,host2,3));
//        Accommodation acc3 = accommodationRepository.save(new Accommodation("Moni's", Category.FLAT,host3,1));
//        Accommodation acc4 = accommodationRepository.save(new Accommodation("Tagora's", Category.MOTEL,host4,1));
//
//        accommodationRepository.save(acc1);
//        accommodationRepository.save(acc2);
//        accommodationRepository.save(acc3);
//        accommodationRepository.save(acc4);
//
//
//        Reservation res1 = reservationRepository.save(new Reservation("1213", LocalDate.now(),LocalDate.now(),2,500,acc1));
//        Reservation res2 = reservationRepository.save(new Reservation("1214",LocalDate.now(),LocalDate.now(),2,500,acc2));
//        Reservation res3 = reservationRepository.save(new Reservation("1253",LocalDate.now(),LocalDate.now(),2,500,acc3));
//
//        reservationRepository.save(res1);
//        reservationRepository.save(res2);
//        reservationRepository.save(res3);
//
//
//
//        User admin = userRepository.save(new User(
//                "admin",
//                passwordEncoder.encode("admin"),
//                "admin",
//                "admin",
//                Role.ROLE_ADMIN
//        ));
//
//        userRepository.save(admin);
//
//        User user = userRepository.save(new User(
//                "user",
//                passwordEncoder.encode("user"),
//                "user",
//                "user",
//                Role.ROLE_USER
//        ));
//        userRepository.save(user);
//
//        TemporaryReservation tmp1 = temporaryReservationRepository.save(new TemporaryReservation("1213", LocalDate.now(),LocalDate.now(),2,500,acc1,user));
//        TemporaryReservation tmp2 = temporaryReservationRepository.save(new TemporaryReservation("1214",LocalDate.now(),LocalDate.now(),2,500,acc2,admin));
//        TemporaryReservation tmp3 = temporaryReservationRepository.save(new TemporaryReservation("1253",LocalDate.now(),LocalDate.now(),2,500,acc3,user));
//        TemporaryReservation tmp4 = temporaryReservationRepository.save(new TemporaryReservation("333",LocalDate.now(),LocalDate.now(),2,500,acc3,admin));
//
//        temporaryReservationRepository.save(tmp1);
//        temporaryReservationRepository.save(tmp2);
//        temporaryReservationRepository.save(tmp3);
//        temporaryReservationRepository.save(tmp4);
//    }
//}
