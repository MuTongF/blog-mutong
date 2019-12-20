package com.mutong.controller.back;

import com.mutong.common.LayuiJson;
import com.mutong.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags="上传模块")
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @ApiOperation("上传图片")
    @PostMapping("/image")
    public LayuiJson uploadImage(@RequestParam("img") MultipartFile img) {
        if (img == null) {
            return LayuiJson.newErrorInstance("文件为空");
        }
        LayuiJson layuiJson = uploadService.uploadImg(img);
        return layuiJson;
    }

    @ApiOperation("Layui上传图片")
    @ApiIgnore
    @PostMapping("/layuiImage")
    public Map<String, Object> layuiImage(@RequestParam("file") MultipartFile img, HttpServletRequest request) {
        String httpPath = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();

        Map<String, Object> map = new HashMap<>();
        if (img == null) {
            map.put("code", 9000);
            map.put("msg", "图片上传失败");
            return map;
        }
        LayuiJson layuiJson = null;
        try {
            layuiJson = uploadService.uploadImg(img);
            String src = (String) layuiJson.getData();
            Map<String, Object> map1 = new HashMap<>();
            map1.put("src", httpPath + src);
            map1.put("title", src.substring(src.lastIndexOf("/")+1));
            map.put("code", 0);
            map.put("data", map1);
        } catch (Exception e) {
//            e.printStackTrace();
            map.put("code", 9000);
            map.put("msg", "图片上传失败");
        }

        return map;
    }

    @ApiOperation("editormd上传图片")
    @ApiIgnore
    @PostMapping("/editormdImage")
    public Map<String,Object> editormdImage(@RequestParam("editormd-image-file") MultipartFile img, HttpServletRequest request) {
        String httpPath = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort();

        Map<String, Object> map = new HashMap<>();
        if (img == null) {
            map.put("success", 9000);
            map.put("message", "图片上传失败");
            return map;
        }
        try {
            LayuiJson layuiJson = uploadService.uploadImg(img);
            String src = (String) layuiJson.getData();
            src=httpPath + src;
            Map<String, Object> map1 = new HashMap<>();
            map.put("success", 1);
            map.put("message", "图片上传成功");
            map.put("url", src);
        } catch (Exception e) {
//            e.printStackTrace();
            map.put("success", 9000);
            map.put("message", "图片上传失败");
        }

        return map;
    }
}
