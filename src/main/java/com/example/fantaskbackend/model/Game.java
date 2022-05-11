package com.example.fantaskbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "spil")
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long gameId;
}
