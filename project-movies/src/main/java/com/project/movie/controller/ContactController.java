package com.project.movie.controller;


import com.project.movie.dao.ContactRepository;
import com.project.movie.document.Contact;
import com.project.movie.document.Film;
import com.project.movie.service.contact.ContactServiceImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class ContactController {

    @Autowired
    private ContactServiceImp contactServiceImp;

    @GetMapping(value = "/contact")
    public ResponseEntity<?> findAllContact() {
        List<Contact> filmList = contactServiceImp.findAllContact();
        return filmList != null ? new ResponseEntity<>(filmList, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/contact", produces = "application/json")
    public ResponseEntity<?> insertContact(@RequestBody(required = true) @Validated Contact contact) {
        return this.contactServiceImp.insertContact(contact) ? new ResponseEntity<>(true, HttpStatus.CREATED) :
                new ResponseEntity<>(false, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/contact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGenre(@PathVariable(value = "id") String id) {
        log.info("deleteGenre infor");
        this.contactServiceImp.delContact(id);
    }

}
