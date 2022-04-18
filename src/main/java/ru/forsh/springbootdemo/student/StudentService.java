package ru.forsh.springbootdemo.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @GetMapping
    public List<Student> getStudents() {
        return List.of(new Student(1L,
                "forsh",
                "forsh@mail.ru",
                LocalDate.of(2020,10,10), 12));
    }
}
