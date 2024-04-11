package com.tntproduction.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Contact_forms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name can't exceed 100 characters")
    private String fullName;

    @Column(name = "email")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[0-9]+", message = "Phone number must contain only digits")
    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
    private String phoneNumber;

    @Column(name = "message")
    @NotBlank(message = "Message is required")
    @Size(max = 1000, message = "Message cannot exceed 1000 characters")
    private String message;
}

