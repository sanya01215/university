package com.siab.university.service;

import com.siab.university.exception.EntityNotFoundException;
import com.siab.university.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findByPersonId(long id) throws EntityNotFoundException;

    Teacher findByPersonName(String teacherName) throws EntityNotFoundException;

    List<Teacher> findAll();

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher, long id);

    void delete(Teacher teacher);

    void deleteById(long id);

    void deleteAll();
}
