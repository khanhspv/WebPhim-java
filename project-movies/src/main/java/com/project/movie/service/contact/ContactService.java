package com.project.movie.service.contact;

import com.project.movie.document.Contact;
import com.project.movie.document.Film;

import java.util.List;

public interface ContactService {

    List<Contact> findAllContact();
    Boolean insertContact(Contact contact);

    void delContact(String id);

}
