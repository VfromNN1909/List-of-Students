package ru.vlasoff.springbootstudents.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlasoff.springbootstudents.model.Student;
import ru.vlasoff.springbootstudents.repos.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo repo;

    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public void save(Student student) {
        this.repo.save(student);
    }

    public void delete(Student student) {
        this.repo.delete(student);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) repo.findAll();
    }

    public Student getStudentById(long id) {
        Optional<Student> optional = repo.findById(id);
        Student student = null;
        try {
            if (optional.isPresent())
                student = optional.get();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return student;
    }
}
