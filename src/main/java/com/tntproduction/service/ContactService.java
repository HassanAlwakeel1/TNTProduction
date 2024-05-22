package com.tntproduction.service;

import com.tntproduction.model.entity.ContactForm;
import org.springframework.http.ResponseEntity;

public interface ContactService {
    ResponseEntity<String> saveContactRequest(ContactForm contactForm);
}
