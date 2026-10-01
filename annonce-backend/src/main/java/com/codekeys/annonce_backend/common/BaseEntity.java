package com.codekeys.annonce_backend.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime creationDate;
    @LastModifiedDate
    @Column(nullable = false,updatable = true, insertable = false)
    private LocalDateTime modificationDate;
    @CreatedBy
    @Column(nullable = false,updatable = false)
    private Long createdBy;
    @LastModifiedBy
    @Column(nullable = false,updatable = true, insertable = false)
    private Long modifiedBy;
}
