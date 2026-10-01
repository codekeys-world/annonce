package com.codekeys.annonce_backend.annonce;

import com.codekeys.annonce_backend.common.BaseEntity;
import com.codekeys.annonce_backend.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "annonce")
@EntityListeners(AuditingEntityListener.class)
public class Annonce extends BaseEntity {
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime dateAnnonce;
    @Column(nullable = false)
    private String statut;
    @Column(nullable = false)
    private String typeAnnonce;
    private double recompense = 0;
    private String question = "";
    private boolean estProuver = true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur annonceur;
}
