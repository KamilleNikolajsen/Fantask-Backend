package com.example.fantaskbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookId;

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(name = "fk_serie")
    private Long series;

    @Column(name = "fk_forfatter")
    private Long author;

    @Column(name = "fk_forlag")
    private Long publisher;

    @Column(name = "fk_kategori")
    private Long category;

    @Column(name = "fk_genre")
    private Long genre;

    @Column(name = "fk_lager")
    private Long storage;

    @Column(name = "nummer")
    private String number;

    @Column(name = "titel")
    private String title;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "dansk_pris")
    private String danishPrice;

    @Column(name = "udgivelsesår")
    private String yearOfPublication;

    @Column(name = "type")
    private String type;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "sider")
    private int pages;

    @Column(nullable = false, name = "dato")
    private Date date;

    @Column(nullable = false, name = "udgået")
    private boolean unavailable;

    @Column(nullable = false, name = "kommende")
    private boolean coming;

    @Column(nullable = false, name = "abonnement")
    private boolean subscription;

    @Column(nullable = false, name = "restordre")
    private boolean backorder;

    @Column(nullable = false, name = "udsolgt")
    private boolean outOfStock;

    @Column(nullable = false, name = "skjul")
    private boolean hidden;

    @Column(nullable = false, name = "tilbud")
    private boolean onSale;

}
