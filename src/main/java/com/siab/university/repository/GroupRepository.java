package com.siab.university.repository;

import com.siab.university.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findById(long Id);

    Optional<Group> deleteById(long Id);
}
