package com.codekeys.annonce_backend.utilisateur;

import com.codekeys.annonce_backend.annonce.Annonce;
import com.codekeys.annonce_backend.common.BaseEntity;
import com.codekeys.annonce_backend.historique.Historique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateur")
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur extends BaseEntity implements UserDetails, Principal {
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String adresse;
    private boolean accountLocked;
    private boolean enabled;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Historique> historiques;

    @OneToMany(mappedBy = "annonceur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Annonce> annonces;

    @Override
    public String getName() {
        return this.email;
    }

    public String fullName() {
        return this.getNom() + " " + this.getPrenom();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
