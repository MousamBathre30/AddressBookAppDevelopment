package com.spring.AddressbookAppDevelopment.controller;

import com.spring.AddressbookAppDevelopment.DTO.ContactDTO;
import com.spring.AddressbookAppDevelopment.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    @Autowired
    private ContactService contactService;

    // Create a contact
    @PostMapping("/add")
    public ContactDTO addContact(@RequestBody ContactDTO contactDTO) {
        return contactService.addContact(contactDTO);
    }

    // Read all contacts
    @GetMapping("/get")
    public List<ContactDTO> getAllContacts() {
        return contactService.getAllContacts();
    }

    // Read a specific contact by ID
    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    // Update a contact
    @PutMapping("/{id}")
    public ContactDTO updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        return contactService.updateContact(id, contactDTO);
    }

    // Delete a contact
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
