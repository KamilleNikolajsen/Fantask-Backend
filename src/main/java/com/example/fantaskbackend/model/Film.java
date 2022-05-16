package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.FilmGenre;
import com.example.fantaskbackend.model.fkmodels.FilmSeries;
import com.example.fantaskbackend.model.fkmodels.FilmTypes;
import com.example.fantaskbackend.model.fkmodels.Storage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_serie")
    private FilmSeries filmSeries;
    //private Long series;

    @ManyToOne()
    @JoinColumn(name = "fk_genre", nullable = false)
    private FilmGenre filmGenre;
    //private Long genre;

    @ManyToOne()
    @JoinColumn(name = "fk_type")
    private FilmTypes filmType;
    //private Long type;

    @ManyToOne()
    @JoinColumn(name = "fk_lager")
    private Storage storage;
    //private Long storage;

    @Column(name = "nummer")
    @FullTextField
    private String number;

    @Column(name = "titel")
    @FullTextField
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

    @GenericField
    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @GenericField
    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(nullable = false)
    private boolean widescreen;

    @GenericField
    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul" , nullable = false)
    private boolean hide;

    @GenericField
    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
