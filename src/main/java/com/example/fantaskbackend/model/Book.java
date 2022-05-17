package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.*;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_serie")
    private BookSeries bookSeries;

    @ManyToMany(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinTable(
            name = "forfatter_tegneserier_bog",
            joinColumns = {@JoinColumn(name = "fk_bog")},
            inverseJoinColumns = {@JoinColumn(name = "fk_forfatter")}
    )
    private Set<Authors> authors = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "fk_forlag")
    private Publisher publisher;

    @ManyToOne()
    @JoinColumn(name = "fk_kategori")
    private BookCategories bookCategory;

    @ManyToOne()
    @JoinColumn(name = "fk_genre")
    private BookGenre bookGenre;

    @ManyToOne
    @JoinColumn(name = "fk_lager")
    private Storage storage;

    @Column(name = "nummer")
    @FullTextField
    private String number;

    @Column(name = "titel")
    @FullTextField
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
    @GenericField
    private Date date;

    @GenericField
    @Column(nullable = false, name = "udgået")
    private boolean unavailable;

    @GenericField
    @Column(nullable = false, name = "kommende")
    private boolean coming;

    @Column(nullable = false, name = "abonnement")
    private boolean subscription;

    @Column(nullable = false, name = "restordre")
    private boolean backorder;

    @GenericField
    @Column(nullable = false, name = "udsolgt")
    private boolean outOfStock;

    @Column(nullable = false, name = "skjul")
    private boolean hide;

    @GenericField
    @Column(nullable = false, name = "tilbud")
    private boolean onSale;

}
