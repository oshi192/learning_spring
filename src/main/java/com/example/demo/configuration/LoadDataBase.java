package com.example.demo.configuration;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Person(100L, 12,"name from loadDb.class")));
            log.info("Preloading " + repository.save(new Person(10L, 21,"chelovekMolodoy")));
        };
    }

}
