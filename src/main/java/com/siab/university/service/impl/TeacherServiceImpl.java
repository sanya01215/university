package com.siab.university.service.impl;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.Teacher;
import com.siab.university.repository.TeacherRepository;
import com.siab.university.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @Override
    public Teacher findByPersonId(long id) throws EntityNotFoundException {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Teacher.class.getName()));
    }

    @Override
    public Teacher findByPersonName(String teacherName) throws EntityNotFoundException {
        return teacherRepository.findByName(teacherName).orElseThrow(() -> new EntityNotFoundException(Teacher.class.getName()));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher, long id) {
        teacher.setId(id);
        teacherRepository.deleteById(id);
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public void deleteById(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
    teacherRepository.deleteAll();
    }
}
