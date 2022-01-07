package com.siab.university.repository;

import com.siab.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);

    Optional<Student> findById(long id);

    Optional<Student> deleteById(long id);

}
