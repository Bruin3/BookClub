package com.exert.service;

import com.exert.utils.ImageVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

    //图片存储路径
    private String localAvatarDir="/Users/xiongpeisen/Codexps/bookclubweb/src/assets/avatar/";
    private String localBookImgDir="/Users/xiongpeisen/Codexps/bookclubweb/src/assets/bookImg/";

    //图片虚拟访问路径(搭配nginx使用)
    private String avatarUrlPath="/avatar/";
    private String bookImgUrlPath="/bookImg/";

    @Override
    public ImageVO uploadAvatar(MultipartFile uploadFile) {

        //获取图片名称
        String fileName = uploadFile.getOriginalFilename();
        //将图片名称转换成小写字母
        fileName = fileName.toLowerCase();
        //正则表达式校验 是否为图片
        if(!fileName.matches("^.+\\.(png|jpg|gif)$")) {
            return ImageVO.fail();
        }
        //校验是否为恶意程序
        try {
            /*BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            int width = bufferedImage .getWidth();
            int height = bufferedImage.getHeight();

            if(width == 0 || height ==0){  //说明 上传的不是图片,为恶意程序.
                return ImageVO.fail();
            }*/

            //按照时间将目录进行划分 yyyy/MM/dd
            /*String deteDir = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
            String localFileDir  = localDir+deteDir;
            File file = new File(localFileDir);
            if(!file.exists()) {//如果目录不存在则创建多级目录
                file.mkdirs();
            }*/

            //动态生成文件名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //abc.jpg
            int index = fileName.lastIndexOf(".");
            String fileType = fileName.substring(index);//截取文件后缀
            String realFileName  = uuid + fileType;

            //文件上传
            String realFilePath = localAvatarDir + realFileName;
            File imageFile = new File(realFilePath);
            uploadFile.transferTo(imageFile);

            String url = avatarUrlPath + realFileName;
            return ImageVO.success(url);
        } catch (IOException e) {
            e.printStackTrace();
            return ImageVO.fail();
        }
    }

    @Override
    public ImageVO uploadBookImg(MultipartFile uploadFile) {

        //获取图片名称
        String fileName = uploadFile.getOriginalFilename();
        //将图片名称转换成小写字母
        fileName = fileName.toLowerCase();
        //正则表达式校验 是否为图片
        if(!fileName.matches("^.+\\.(png|jpg|gif)$")) {
            return ImageVO.fail();
        }
        //校验是否为恶意程序
        try {

            //动态生成文件名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //abc.jpg
            int index = fileName.lastIndexOf(".");
            String fileType = fileName.substring(index);//截取文件后缀
            String realFileName  = uuid + fileType;

            //文件上传
            String realFilePath = localBookImgDir + realFileName;
            File imageFile = new File(realFilePath);
            uploadFile.transferTo(imageFile);

            String url = bookImgUrlPath + realFileName;
            return ImageVO.success(url);
        } catch (IOException e) {
            e.printStackTrace();
            return ImageVO.fail();
        }
    }
}
