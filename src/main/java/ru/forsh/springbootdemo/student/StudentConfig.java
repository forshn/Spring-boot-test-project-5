package ru.forsh.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student lera = new Student(
                    "Lera",
                    "forsh@mail.ru",
                    LocalDate.of(2022, 04, 17));

            Student kolya = new Student(
                    "Kolya",
                    "Kolya@mail.ru",
                    LocalDate.of(2022, 04, 17));

            repository.saveAll(List.of(lera,kolya));
        };
    }
}
