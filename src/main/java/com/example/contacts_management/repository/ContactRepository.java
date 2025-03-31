package com.example.contacts_management.repository;

import com.example.contacts_management.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
