package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.model.Enumerations.Role;
import mk.ukim.finki.lab1b.model.Projections.UserProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"carts"}
    )
    @Query("select u from User u")
    List<User> fetchAll();

    @EntityGraph(
            type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {"carts"}
    )
    @Query("select u from User u")
    List<User> loadAll();

    UserProjection findByRole(Role role);

    @Query("select u.username, u.firstName, u.lastname from User u")
    List<UserProjection> takeUsernameAndNameAndSurnameByProjection();



    @EntityGraph(value = "User.withoutTemporaryReservations", type = EntityGraph.EntityGraphType.LOAD)
    List<User> findAll();

}
