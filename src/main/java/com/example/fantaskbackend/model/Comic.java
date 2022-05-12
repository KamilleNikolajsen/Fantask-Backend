package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tegneserier")
@Getter
@Setter
@Indexed
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long comicId;

    @ManyToOne()
    @JoinColumn(name = "fk_serie")
    private ComicSeries comicSeries;

   //@Column(name = "fk_serie")
    //private Long series;

    @ManyToOne()
    @JoinColumn(name = "fk_forlag")
    private Publisher publisher;
    //private Long publisher;

    @ManyToOne()
    @JoinColumn(name = "fk_type")
    private ComicTypes comicType;
    //private Long type;

    @ManyToMany()
    @IndexedEmbedded
    @JoinTable(
            name = "tegner_tegneserier",
            joinColumns = {@JoinColumn(name = "fk_tegneserier")},
            inverseJoinColumns = {@JoinColumn(name = "fk_tegner")}
    )
    private Set<Artist> artists= new HashSet<>();

    // Slettes når alt spiller
    @Column(name = "fk_tegner_tegneserie")
    private Long artistComic;

    @ManyToMany()
    @IndexedEmbedded
    @JoinTable(
            name = "forfatter_tegneserier_bog",
            joinColumns = {@JoinColumn(name = "fk_tegneserier")},
            inverseJoinColumns = {@JoinColumn(name = "fk_forfatter")}
    )
    private Set<Authors> authors= new HashSet<>();

    @Column(name = "fk_forfatter_tegneserier_bog")
    private Long author;

    @ManyToOne()
    @JoinColumn(name = "fk_underserie")
    private ComicSubseries comicSubserie;

    //@Column(name = "fk_underserie")
    //private Long subseries;

    @ManyToOne()
    @JoinColumn(name = "fk_lager")
    private Storage storage;
    //private Long storage;

    @Column(name = "nummer")
    private String number;

    @Column(name = "titel")
    private String title;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "dansk_pris", nullable = false)
    private String danishPrice;

    @KeywordField
    private String ISBN;

    @Column(name = "star_ID")
    private String starId;

    @Column(name = "dato")
    private Date date;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    private boolean onSale;


}
