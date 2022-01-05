package com.siab.university.service;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.Student;

import java.util.List;

public interface StudentService {
    Student findByPersonId(long id) throws EntityNotFoundException;

    Student findByPersonName(String studentName) throws EntityNotFoundException;

    List<Student> findAll();

    Student update(Student person, long id);

    Student save(Student student);

    void delete(Student student);

    Student deleteById(long id);

    void deleteAll();
}
