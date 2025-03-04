package com.spring.AddressbookAppDevelopment.Repo;

import com.spring.AddressbookAppDevelopment.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
