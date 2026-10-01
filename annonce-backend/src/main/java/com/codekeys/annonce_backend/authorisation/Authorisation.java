package com.codekeys.annonce_backend.authorisation;

import com.codekeys.annonce_backend.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "autorisation")
@EntityListeners(AuditingEntityListener.class)
public class Authorisation {
    @Column(nullable = false, unique = true)
    private String nom;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private Role role;
}
