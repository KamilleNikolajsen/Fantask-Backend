package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.Authors;
import com.example.fantaskbackend.model.fkmodels.BookSeries;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Indexed
@Table(name = "bog")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookId;

    @KeywordField
    @Column(nullable = false, unique = true)
    private String ISBN;

    @ManyToOne()
    @JoinColumn(name = "fk_serie")
    private BookSeries bookSeries;

    //@Column(name = "fk_serie")
    //private Long series;

    @ManyToMany()
    @IndexedEmbedded
    @JoinTable(
           name = "forfatter_tegneserier_bog",
            joinColumns = {@JoinColumn(name = "fk_bog")},
            inverseJoinColumns = {@JoinColumn(name = "fk_forfatter")}
    )
    private Set<Authors> authors= new HashSet<>();


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
    private Integer pages;

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
    private boolean hide;

    @Column(nullable = false, name = "tilbud")
    private boolean onSale;

}
