package com.siab.university.model;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @OneToOne(targetEntity = Group.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_group_id")
    private Group group;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

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
