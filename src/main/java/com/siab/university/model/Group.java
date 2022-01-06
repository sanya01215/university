package com.siab.university.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "group_name")
    private String name;

    @OneToOne(targetEntity = Teacher.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher groupTeacher;

    @OneToMany(targetEntity = Student.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_students_id")
    private List<Student> students;
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
