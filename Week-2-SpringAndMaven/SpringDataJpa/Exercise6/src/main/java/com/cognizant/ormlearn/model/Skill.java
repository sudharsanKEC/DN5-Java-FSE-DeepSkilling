package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="skill")
@Getter
@Setter
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sk_id")
    private int id;

    @Column(name="sk_name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<Employee> employees;

    public Skill(){}

    // getters and setters

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}