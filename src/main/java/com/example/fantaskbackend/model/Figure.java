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
@Table(name = "figurer")
@Getter
@Setter
@Indexed
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long figureId;

    @Column(name = "figur_nummer", nullable = false)
    private String figureNumber;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "fk_figur_kategori")
    private FigureCategories figureCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @IndexedEmbedded
    @JoinColumn(name = "fk_serie")
    private FigureSeries figureSeries;

    @ManyToOne()
    @JoinColumn(name = "fk_lager")
    private Storage storage;

    @ManyToOne()
    @JoinColumn(name = "fk_figur_producent")
    private GameManufacturer manufacturer;

    @Column(name = "producent_id", nullable = false)
    private String manufacturerId;

    @Column(name = "titel")
    @FullTextField
    private String title;

    @Column(name = "pris")
    private String price;

    @Column(name = "original_pris")
    private String originalPrice;

    @Column(name = "beskrivelse")
    private String description;

    @Column(name = "antal")
    private Integer amount;

    @GenericField
    @Column(name = "dato", nullable = false)
    private Date date;

    @Column(name = "udgået", nullable = false)
    @GenericField
    private boolean unavailable;

    @Column(nullable = false)
    @GenericField
    private boolean box;

    @Column(name = "abonnement", nullable = false)
    private boolean subscription;

    @Column(name = "restordre", nullable = false)
    private boolean backorder;

    @Column(name = "kommende", nullable = false)
    @GenericField
    private boolean coming;

    @Column(name = "udsolgt", nullable = false)
    @GenericField
    private boolean outOfStock;

    @Column(name = "skjul", nullable = false)
    private boolean hide;

    @Column(name = "tilbud", nullable = false)
    @GenericField
    private boolean onSale;
}
