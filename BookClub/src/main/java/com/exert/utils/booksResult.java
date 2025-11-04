package com.exert.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class booksResult {

    private int rank;
    private String img;
    private String bookName;
    private String author;
    private int publishYear;
    private String params;
    private int number;
    private boolean collect;
    private String synopsis;

}
