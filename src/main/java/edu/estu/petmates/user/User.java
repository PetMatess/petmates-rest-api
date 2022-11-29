package edu.estu.petmates.user;

import com.fasterxml.jackson.annotation.JsonView;
import edu.estu.petmates.shared.Views;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(max = 70)
    @JsonView(Views.Base.class)
    private String firstName;

    @NotNull
    @Size(max = 70)
    @JsonView(Views.Base.class)
    private String surname;

    /*@NotNull
    @Size(min = 4, max = 255)
    @UniqueUsername
    @JsonView(Views.Base.class)
    private String username;*/

    @Column(name = "email")
    @NotNull
    @UniqueUsername
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @JsonView(Views.Base.class)
    private String username; //email

    @NotNull
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$")
    @JsonView(Views.Base.class)
    private String phoneNumber;

    @NotNull
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    @JsonView(Views.Sensitive.class)
    private String password;

    @JsonView(Views.Base.class)
    private String image;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_user");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
