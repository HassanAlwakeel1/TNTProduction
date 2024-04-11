package com.tntproduction.repository;

import com.tntproduction.model.entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactForm,Long> {
}
