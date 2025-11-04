package com.exert.utils;

import com.exert.pojo.Msg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class msgPage {

    private int pagenum;
    private int total;
    private List<Msg> msg;

}
