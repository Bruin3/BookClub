package com.exert.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookParamsPage {

    private int pagenum;
    private int total;
    private List<bookParamResult> bpr;

}
