package com.ayushkamadji.javersscenario.JaversScenario.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "todo")
@Inheritance( strategy = InheritanceType.JOINED )
public class Todo {

    @Id
    @SequenceGenerator(name = "todo_id_seq", sequenceName = "todo_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_id_seq")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;
}
