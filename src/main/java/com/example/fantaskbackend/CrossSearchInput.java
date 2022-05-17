package com.example.fantaskbackend;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CrossSearchInput {

    private String ftsInput;

    private boolean showComing;

    private boolean excludeComing;

    private boolean unavailable;

    private boolean outOfStock;

    private boolean onSale;

    private boolean box;

    private String date;
}
