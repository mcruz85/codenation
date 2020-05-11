package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

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

    @OneToMany
    private List<Acceleration> accelerations = new ArrayList<>();

    @OneToMany
    private List<Submission> submissions = new ArrayList<>();

    @CreatedDate
    private OffsetDateTime createdAt;
}
