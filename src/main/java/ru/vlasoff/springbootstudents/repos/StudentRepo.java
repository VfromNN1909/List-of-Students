package ru.vlasoff.springbootstudents.repos;

import org.springframework.data.repository.CrudRepository;
import ru.vlasoff.springbootstudents.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
