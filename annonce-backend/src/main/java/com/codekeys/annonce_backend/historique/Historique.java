package com.codekeys.annonce_backend.historique;

import com.codekeys.annonce_backend.common.BaseEntity;
import com.codekeys.annonce_backend.utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historique")
@EntityListeners(AuditingEntityListener.class)
public class Historique extends BaseEntity {
    private String action;
    private LocalDateTime dateAction;
    private Time heureAction;
    private String adresseIp;
    private String client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;
}
