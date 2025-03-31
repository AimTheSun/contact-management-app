package com.example.contacts_management.controller;

import com.example.contacts_management.model.Contact;
import com.example.contacts_management.repository.ContactRepository;
import jakarta.persistence.Entity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController (ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @RequestMapping
    public Iterable<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @PutMapping
    public Contact updateContact( @PathVariable Long id ,@RequestBody Contact updatedContact){
        return contactRepository.findById(id).map(contact -> {
            contact.setFirstName(updatedContact.getFirstName());
            contact.setLastName(updatedContact.getLastName());
            contact.setZipCode(updatedContact.getZipCode());
            contact.setDateOfBirth(updatedContact.getDateOfBirth());
            return contactRepository.save(contact);
        }).orElseThrow(() -> new RuntimeException("Contact not found with id " + id));
    }
}
    }

}
