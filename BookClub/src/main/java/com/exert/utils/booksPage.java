package com.exert.utils;

import com.exert.pojo.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class booksPage {

    private int pagenum;
    private int total;
    private List<Books> books;

}
