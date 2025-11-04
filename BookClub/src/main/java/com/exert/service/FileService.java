package com.exert.service;

import com.exert.utils.ImageVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    //头像图片上传
    public ImageVO uploadAvatar(MultipartFile uploadFile);

    //书籍图片上传
    ImageVO uploadBookImg(MultipartFile uploadFile);
}
