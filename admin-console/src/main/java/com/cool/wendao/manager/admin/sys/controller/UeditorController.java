package com.cool.wendao.manager.admin.sys.controller;

import com.cool.wendao.manager.admin.sys.service.ImgService;
import com.cool.wendao.manager.admin.sys.vo.ImgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 百度 ueditor 富文本编辑器集成
 *
 * @author cool
 * 2019年4月5日12:31:00
 */
@Controller
@RequestMapping(value = "/ueditor")
public class UeditorController {

    private final ImgService imgService;

    @Autowired
    public UeditorController(ImgService imgService) {
        this.imgService = imgService;
    }

    @Value("${request_image_url}")
    public String requestImageUrl;

    /**
     * 文本编辑器的配置  只剩下上传图片
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/config")
    @ResponseBody
    public String config(HttpServletRequest request, HttpServletResponse response) {
        String imagePathFormat = request.getContextPath() + "/ueditor/imgUpdate";
        String s = "{\n" +
                "                \"imageActionName\": \"uploadimage\",\n" +
                "                \"imageFieldName\": \"file\", \n" +
                "                \"imageMaxSize\": 10240000, \n" +
                "                \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" +
                "                \"imageCompressEnable\": true, \n" +
                "                \"imageCompressBorder\": 1600, \n" +
                "                \"imageInsertAlign\": \"none\", \n" +
                "                \"imageUrlPrefix\": \"\",\n" +
                "                \"imagePathFormat\": \"" + imagePathFormat + "\" }";
        return s;
    }

    @PostMapping(value = "/imgUpdate")
    @ResponseBody
    public String imgUpdate(MultipartFile file) {
        if (file.isEmpty()) {
            return "error";
        }
        try {
            ImgVo imgVo = imgService.uploadImg(file, "ueditor", 0);
            imgVo.setRequestImageUrl(requestImageUrl);
            //url的值为图片的实际访问地址 这里我用了Nginx代理，访问的路径是http://localhost/xxx.png
            String config = "{\"state\": \"SUCCESS\"," +
                    "\"url\": \"" + imgVo.getBigPath() + "\"," +
                    "\"title\": \"" + imgVo.getTitle() + "\"," +
                    "\"original\": \"" + imgVo.getTitle() + "\"}";
            return config;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
