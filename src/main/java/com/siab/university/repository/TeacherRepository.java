package com.siab.university.repository;

import com.siab.university.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByName(String name);

    Optional<Teacher> findById(long id);

    Optional<Teacher> deleteById(long id);
}
