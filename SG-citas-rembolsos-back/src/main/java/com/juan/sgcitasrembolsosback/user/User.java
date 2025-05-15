package com.juan.sgcitasrembolsosback.user;

import com.juan.sgcitasrembolsosback.role.Role;
import com.juan.sgcitasrembolsosback.role.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails, Principal{
    /*Uset datails se imprementa para proveer a Spring security de información relevante:
    _ Si la cuenta expiró
    - Si la cuenta no está bloqueada
    - Si los credenciales no han expirado
    - Si la cuenta está habilitada
    */
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;
    @Setter
    private String email;
    //@JsonIgnore
    @Setter
    private String password;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public String getName() {
        return getUsername();
    }
}
