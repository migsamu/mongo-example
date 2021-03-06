package org.iesfm.mongo;

import org.iesfm.mongo.repository.EmailRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        EmailRepository emailRepository = context.getBean(EmailRepository.class);

        emailRepository.save(
                new Email(List.of("alguien@gmail.com", "otro@gmail.com"),
                        "Bienvenido",
                        "Hola te has registrado correctamente")
        );

        List<Email> emails = emailRepository.findByTo("otro@gmail.com");
        for (Email email : emails){
            System.out.println(email.toString());
        }

    }
}
