package com.siab.university.service.impl;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.Student;
import com.siab.university.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements com.siab.university.service.StudentService {
    private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findByPersonId(long id) throws EntityNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Student.class.getName()));
    }


    @Override
    public Student findByPersonName(String studentName) throws EntityNotFoundException {
        return studentRepository.findByName(studentName).orElseThrow(() -> new EntityNotFoundException(Student.class.getName()));
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }



    @Override
    public Student update(Student person, long id) {
        person.setId(id);
        studentRepository.deleteById(id);
        return studentRepository.save(person);
    }


    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }



    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }


    @Override
    public Student deleteById(long id) {
        return studentRepository.deleteById(id).orElseThrow(() -> new EntityNotFoundException(Student.class.getName()));
    }


    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
