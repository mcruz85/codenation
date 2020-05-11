package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    private Challenge challenge;

    @OneToMany(mappedBy = "id.acceleration")
    private List<Candidate> candidates;

    @CreatedDate
    private OffsetDateTime createdAt;
}
