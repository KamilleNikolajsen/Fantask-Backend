package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "spil")
@Getter
@Setter
@Indexed
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long gameId;

    @Column(name = "vare_nr")
    private Long itemNumber;

    @Column(name = "spil_nr")
    private String gameNumber;

    @Column(name = "producent_id")
    private String manufacturerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_serie")
    private GameSeries gameSeries;

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_underserie")
    private GameSubseries gameSubseries;

    @ManyToOne()
    @JoinColumn(name = "fk_kategori")
    private GameCategories gameCategory;

    @ManyToOne()
    @JoinColumn(name = "fk_type")
    private GameTypes gameType;

    @ManyToOne()
    @JoinColumn(name = "fk_kateogori_type")
    private GameCategoryTypes gameCategoryType;

    @ManyToOne()
    @JoinColumn(name = "fk_spil_producent")
    private GameManufacturer manufacturer;

    @ManyToOne()
    @JoinColumn(name = "fk_lager")
    private Storage storage;

    @Column(name = "titel")
    @FullTextField
    private String title;

    @Column(name = "modul_hjælpemiddel")
    private String moduleAssistance;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "pris")
    private String price;

    @Column(name = "sværhedsgrad")
    private String difficulty;

    @Column(name = "spillere")
    private String players;

    @Column(name = "spilletid")
    private String gameTime;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "dato")
    @GenericField
    private Date date;

    @GenericField
    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @GenericField
    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @GenericField
    @Column(nullable = false)
    private boolean box;

    @GenericField
    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @GenericField
    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
