package com.mutong.service;

import com.mutong.common.LayuiJson;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 上传图片
     * @param img
     * @return
     */
    LayuiJson uploadImg(MultipartFile img);

    /**
     * 用于删除数据时删除图片
     * @param imgPath
     */
    void deleteImg(String imgPath);
}
