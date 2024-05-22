package com.tntproduction.controller;

import com.tntproduction.model.entity.ContactForm;
import com.tntproduction.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contact")
public class ContactController {
    private final ContactService contactService;

    @PostMapping("/save-contact-form")
    public ResponseEntity<String> saveContactRequest(@RequestBody ContactForm contactForm){
        return contactService.saveContactRequest(contactForm);
    }
}
