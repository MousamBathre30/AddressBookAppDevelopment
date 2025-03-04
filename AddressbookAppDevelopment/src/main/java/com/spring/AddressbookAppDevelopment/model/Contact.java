package com.spring.AddressbookAppDevelopment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.processing.Generated;


@Slf4j
@Entity
@Table(name = "contacts")
@NoArgsConstructor
public @Data class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true ,nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phone;
}
