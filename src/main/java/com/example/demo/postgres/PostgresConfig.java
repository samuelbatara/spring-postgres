package com.example.demo.postgres;

import com.example.demo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class PostgresConfig {
    @Bean
    CommandLineRunner addDummyStudent(StudentRepository studentRepository) {
        return args -> {
            Student armin = new Student(
                    "Armin",
                    "armin@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );
            Student melina = new Student(
                    "Melina",
                    "melina@gmail.com",
                    LocalDate.of(2001, AUGUST, 21)
            );

            studentRepository.saveAll(List.of(armin, melina));
        };
    }
}
