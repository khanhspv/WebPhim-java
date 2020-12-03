package com.project.movie.dao;

import com.project.movie.document.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository  extends MongoRepository<Contact, String> {
}
