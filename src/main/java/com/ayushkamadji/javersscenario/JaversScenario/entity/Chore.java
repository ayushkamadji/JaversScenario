package com.ayushkamadji.javersscenario.JaversScenario.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "chore")
public class Chore extends Todo {

    private Long id;

    private String location;
}
