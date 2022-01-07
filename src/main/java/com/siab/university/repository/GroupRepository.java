package com.siab.university.repository;

import com.siab.university.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findById(long Id);

    Optional<Group> deleteById(long Id);
}
