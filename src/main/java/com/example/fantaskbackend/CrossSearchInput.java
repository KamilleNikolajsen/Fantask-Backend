package com.example.fantaskbackend;

import lombok.Getter;

@Getter
public class CrossSearchInput {

    private String ftsInput;

    private boolean showComing;

    private boolean excludeComing;

    private boolean unavailable;

    private boolean outOfStock;

    private boolean onSale;

    private boolean box;
}
