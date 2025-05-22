package mk.ukim.finki.lab1b.model.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab1b.model.Enumerations.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@NamedEntityGraph(
        name = "User.withoutTemporaryReservations",
        attributeNodes = {
                @NamedAttributeNode("username"),
                @NamedAttributeNode("firstName"),
                @NamedAttributeNode("lastname"),
                @NamedAttributeNode("role"),
        }
)
@Data
@Entity
@Table(name = "system_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastname;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    // default:
    // to-one -> FetchType.EAGER
    // to-many -> FetchType.LAZY
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<ShoppingCart> carts;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TemporaryReservation> temporaryReservations;

    public User() {
    }

    public User(String username, String password, String firstName, String lastname, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.role = role;
    }

    public User(String username, String password, String firstName, String lastname) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.role = Role.ROLE_USER;
    }

    public User(UserDetails userDetails) {
        this.username = userDetails.getUsername();
        this.password = userDetails.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList((GrantedAuthority) role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
