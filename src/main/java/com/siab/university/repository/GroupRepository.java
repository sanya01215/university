package com.siab.university.repository;

import com.siab.university.model.Student;
import com.siab.university.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<StudentGroup,Long> {
    Optional<StudentGroup> findByName(String name);
    Optional<StudentGroup> findById(long Id);
    Optional<StudentGroup> deleteById(long Id);
}
