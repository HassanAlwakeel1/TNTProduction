package com.tntproduction.service.impl;

import com.tntproduction.model.entity.ContactForm;
import com.tntproduction.repository.ContactRepository;
import com.tntproduction.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ResponseEntity<String> saveContactRequest(ContactForm contactForm) {
        contactRepository.save(contactForm);
        return ResponseEntity.ok("Thank you for contacting us! Your message has been received," +
                " and we will get back to you as soon as possible.");
    }
}
