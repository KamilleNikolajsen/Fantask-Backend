package com.example.fantaskbackend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@AllArgsConstructor
public class CrossSearchItem {
// Destination model for Cross Search FTS. Model for return data.
    private Long id;

    @Nullable
    private List<String> author;

    private String series;

    private String title;

    @Nullable
    private String subSeries;

    @Nullable
    private String number;

    private String type;
}
