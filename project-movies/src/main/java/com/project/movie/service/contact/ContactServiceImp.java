package com.project.movie.service.contact;


import com.project.movie.dao.ContactRepository;
import com.project.movie.document.Contact;
import com.project.movie.document.Genre;
import com.project.movie.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Boolean insertContact(Contact contact) {
        return (contactRepository.save(contact) instanceof Contact);
    }

    @Override
    public void delContact(String id) {
        Contact contact = contactRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        contactRepository.deleteById(id);
    }


}
