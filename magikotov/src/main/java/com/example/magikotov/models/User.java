package com.example.magikotov.models;

import com.example.magikotov.models.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name="email", unique = true)
    private String email;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="name")
    private String name;
    @Column(name="active")
    private boolean active;
    @Column(name="password", length = 1000)
    private String password;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image avatar;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
    joinColumns = @JoinColumn(name= "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    private LocalDateTime dateOfCreate;

    @PrePersist
    private void init(){
        dateOfCreate =LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
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
        return active;
    }
}