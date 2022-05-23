package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tegneserier")
@Getter
@Setter
@Indexed
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "comicId")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long comicId;

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_serie")
    private ComicSeries comicSeries;

    @ManyToOne()
    @JsonBackReference(value = "comicPublisher")
    @JoinColumn(name = "fk_forlag")
    private Publisher publisher;

    @ManyToOne()
    @JoinColumn(name = "fk_type")
    private ComicTypes comicType;

    @ManyToMany(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinTable(
            name = "tegner_tegneserier",
            joinColumns = {@JoinColumn(name = "fk_tegneserier")},
            inverseJoinColumns = {@JoinColumn(name = "fk_tegner")}
    )
    private Set<Artist> artists= new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @IndexedEmbedded
   // @JsonManagedReference(value = "comicAuthors")
    @JoinTable(
            name = "forfatter_tegneserier_bog",
            joinColumns = {@JoinColumn(name = "fk_tegneserier")},
            inverseJoinColumns = {@JoinColumn(name = "fk_forfatter")}
    )
    private Set<Authors> authors= new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_underserie")
    private ComicSubseries comicSubseries;

    @ManyToOne()
    @JsonBackReference(value = "comicStorage")
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

    @Column(name = "dansk_pris", nullable = false)
    private String danishPrice;

    @Column(name = "tilbudspris")
    private String salePrice;

    @KeywordField
    private String ISBN;

    @Column(name = "star_ID")
    private String starId;

    @GenericField
    @Column(name = "dato")
    private Date date;

    @Column(name = "beskrivelse")
    private String description;

    @GenericField
    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @GenericField
    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @GenericField
    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @GenericField
    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
