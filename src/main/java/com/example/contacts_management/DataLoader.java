package com.example.contacts_management;

import com.example.contacts_management.model.Contact;
import com.example.contacts_management.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.Random;

public class DataLoader implements CommandLineRunner {
    private final ContactRepository contactRepository;
    private final Random random = new Random();

    public DataLoader(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (contactRepository.count() == 0) {
            for (int i = 0; i < 1000; i++){
                String firstName = "First" + i;
                String lastName = "Last" + i;
                String zipCode = String.format("%s", random.nextInt(100000));
                int year = 1960 + random.nextInt(61);
                int month = 1 + random.nextInt(12);
                int day = 1 + random.nextInt(31);
                LocalDate dob = LocalDate.of(year, month, day);

                Contact contact = new Contact (firstName, lastName, zipCode, dob);
                contactRepository.save(contact);
            }
                System.out.println("Data loaded successfully.");
        }
    }
}
