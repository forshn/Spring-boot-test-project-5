package ru.forsh.springbootdemo.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        boolean b = studentRepository.findAll()
                .stream()
                .anyMatch(s -> s.getEmail().equals(student.getEmail())) ;
        if (!b){
            studentRepository.save(student);
        } else System.out.println("wrong email");
    }
}
