package com.exert.utils;

import com.exert.pojo.Params;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paramsPage {

    private int pagenum;
    private int total;
    private List<Params> params;

}
