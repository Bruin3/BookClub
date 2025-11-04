package com.exert.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
    //{"error":0,"url":"图片的保存路径","width":图片的宽度,"height":图片的高度}
    private Integer error;  //是否上传正确  0正常  1错误
    private String url;     //图片的访问路径
    //为了调用方便准备工具方法
    public static ImageVO fail() {
        return new ImageVO(1, null);
    }

    public static ImageVO success(String url) {
        return new ImageVO(0, url);
    }
}
