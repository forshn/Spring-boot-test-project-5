package ru.forsh.springbootdemo.student;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        boolean present = studentRepository
                .findStudentByEmail(student.getEmail())
                .isPresent();
        if (!present) {
            studentRepository.save(student);
        } else System.out.println("wrong email");
    }

    public void deleteStudent(Long id) {
        boolean b = studentRepository.existsById(id);

        if (!b) {
            throw new IllegalStateException("student doesn't exists");
        } else studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findStudentById(id)
                .orElseThrow(() -> new IllegalStateException("student doesn't exists"));

        if (name != null && !name.equals(student.getName()) && name.length() > 0) {
            student.setName(name);
        }
        if (email != null && !email.equals(student.getEmail()) && email.length() > 0) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
