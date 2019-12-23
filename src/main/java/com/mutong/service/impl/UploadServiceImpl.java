package com.mutong.service.impl;

import com.mutong.common.LayuiJson;
import com.mutong.service.UploadService;
import com.mutong.util.RandomUtil;
import com.mutong.util.TimeUtil;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
    @Value("${upload.filePath}")
    private String uploadFilePath;

    private static String imgDirectory = "/image/";

    @Override
    public LayuiJson uploadImg(MultipartFile img) {
        String fileName = img.getOriginalFilename();

        String imgType = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        String stringDate = TimeUtil.GetStringDate(new Date(), "yyyy-MM-dd");
        String filePath = uploadFilePath + stringDate + "/";

        File targetFile = new File(filePath);
        //判断上级文件夹是否存在
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        String name = RandomUtil.getNumberRandom(4) + System.currentTimeMillis() + imgType;
        File imgFile = new File(filePath + name);


        String httpPath = "";

        try {
            img.transferTo(imgFile);
            httpPath = imgDirectory + stringDate + "/" + name;
        } catch (IOException e) {
            e.printStackTrace();
            return LayuiJson.newErrorInstance("上传失败");
        }


        return LayuiJson.newInstance("上传成功", httpPath);
    }

    @Override
    public void deleteImg(String imgPath) {
        imgPath = imgPath.substring(imgDirectory.length(), imgPath.length());
        File imgFile = new File(uploadFilePath + imgPath);
        if (!imgFile.exists()){
            return;
        }
        imgFile.delete();
        File parentFile = imgFile.getParentFile();
        File[] files = parentFile.listFiles();
        if (files.length == 0) {
            //删除空文件夹
            if(parentFile.exists()){
                parentFile.delete();
            }
        }
    }


    public static void main(String[] args) {
        String path = "C:\\upload\\image\\2019-09-27\\1569578874100.png";
        File file = new File(path);
        File parentFile = file.getParentFile();
//        clear(file);
    }

}
