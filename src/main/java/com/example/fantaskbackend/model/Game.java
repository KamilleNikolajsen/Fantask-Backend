package com.example.fantaskbackend.model;

import com.example.fantaskbackend.model.fkmodels.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
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

    @ManyToOne()
    @IndexedEmbedded
    @JoinColumn(name = "fk_serie")
    private GameSeries gameSeries;

    /*@Column(name = "fk_serie")
    private Long series;
     */

    @ManyToOne()
    @IndexedEmbedded
    @JoinColumn(name = "fk_underserie")
    private GameSubseries gameSubseries;

    /*@Column(name = "fk_underserie")
    private Long subseries;
     */

    @ManyToOne()
    @JoinColumn(name = "fk_kategori")
    private GameCategories gameCategory;
    //private Long category;

    @ManyToOne()
    @JoinColumn(name = "fk_type")
    private GameTypes gameType;
    //private Long type;

    @ManyToOne()
    @JoinColumn(name = "fk_kateogori_type")
    private GameCategoryTypes gameCategoryType;
    //private Long categoryType;

    @ManyToOne()
    @JoinColumn(name = "fk_spil_producent")
    private GameManufacturer manufacturer;
    //private Long manufacturer;

    @ManyToOne()
    @JoinColumn(name = "fk_lager")
    private Storage storage;
    //private Long storage;

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
    private Date date;

    @Column(name = "udgået", nullable = false)
    private boolean unavailable;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "kommende", nullable = false)
    private boolean coming;

    @Column(nullable = false)
    private boolean box;

    @Column(name = "udsolgt", nullable = false)
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    private boolean onSale;
}
