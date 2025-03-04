package com.spring.AddressbookAppDevelopment.controller;// AddressBookController.java
import com.spring.AddressbookAppDevelopment.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private final List<Contact> contacts = new ArrayList<>();

    // Create a contact
    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.add(contact);
        return contact;
    }

    // Read all contacts
    @GetMapping("/get")
    public List<Contact> getAllContacts() {
        return contacts;
    }

    // Read a specific contact by ID
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElse(null); // or throw NotFoundException
    }

    // Update a contact
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .ifPresent(contact -> {
                    contact.setName(updatedContact.getName());
                    contact.setEmail(updatedContact.getEmail());
                    contact.setPhone(updatedContact.getPhone());
                });
        return updatedContact;
    }

    // Delete a contact
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contacts.removeIf(contact -> contact.getId().equals(id));
    }
}
