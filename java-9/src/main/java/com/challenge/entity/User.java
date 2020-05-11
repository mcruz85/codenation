package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, name = "full_name", length = 100)
    private String fullName;

    @Email
    @Size(max = 100)
    @NotNull
    @Column(nullable = false, length = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    @Column(length = 255)
    private String password;

    @OneToMany
    private List<Candidate> candidates = new ArrayList<>();

    @OneToMany
    private List<Submission> submissions = new ArrayList<>();

    @CreatedDate
    private OffsetDateTime createdAt;

}
