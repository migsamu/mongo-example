package org.iesfm.mongo.repository;

import org.iesfm.mongo.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmailRepository extends MongoRepository<Email, Integer> {
}
