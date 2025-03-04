package com.spring.AddressbookAppDevelopment.service;

import com.spring.AddressbookAppDevelopment.DTO.ContactDTO;
import com.spring.AddressbookAppDevelopment.Repo.ContactRepository;
import com.spring.AddressbookAppDevelopment.model.Contact;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@Getter
@Setter
public  class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Create a new contact
    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhone(contactDTO.getPhone());

        Contact savedContact = contactRepository.save(contact);

        return new ContactDTO(savedContact.getFirstName(), savedContact.getLastName(), savedContact.getEmail(), savedContact.getPhone());
    }

    // Get all contacts
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> new ContactDTO(contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone()))
                .collect(Collectors.toList());
    }

    // Get contact by ID
    public ContactDTO getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(c -> new ContactDTO(c.getFirstName(), c.getLastName(), c.getEmail(), c.getPhone())).orElse(null);
    }

    // Update contact
    public ContactDTO updateContact(Long id, ContactDTO contactDTO) {
        Optional<Contact> existingContact = contactRepository.findById(id);

        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setFirstName(contactDTO.getFirstName());
            contact.setLastName(contactDTO.getLastName());
            contact.setEmail(contactDTO.getEmail());
            contact.setPhone(contactDTO.getPhone());

            Contact updatedContact = contactRepository.save(contact);
            return new ContactDTO(updatedContact.getFirstName(), updatedContact.getLastName(), updatedContact.getEmail(), updatedContact.getPhone());
        }
        return null; // Handle not found case properly
    }

    // Delete contact by ID
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
