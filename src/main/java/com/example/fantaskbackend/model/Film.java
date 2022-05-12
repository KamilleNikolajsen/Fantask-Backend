package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.FilmSeries;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Indexed
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long filmId;

    @Column(name = "video_nr", nullable = false)
    private String videoNumber;

    @ManyToOne
    @Column(name = "fk_serie")
    private FilmSeries series;
    //private Long series;

    @Column(name = "fk_genre", nullable = false)
    private Long genre;

    @Column(name = "fk_type")
    private Long type;

    @Column(name = "fk_lager")
    private Long storage;

    @Column(name = "nummer")
    private String number;

    @Column(name = "titel")
    private String title;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "pris")
    private String price;

    @Column(name = "minutter")
    private Integer minutes;

    @Column(name = "dato", nullable = false)
    private Date date;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(nullable = false)
    private boolean widescreen;

    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul" , nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
