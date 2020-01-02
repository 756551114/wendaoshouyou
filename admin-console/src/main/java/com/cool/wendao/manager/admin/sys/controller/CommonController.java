package com.cool.wendao.manager.admin.sys.controller;

import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.manager.admin.sys.service.ImgService;
import com.cool.wendao.manager.admin.sys.exception.ImgException;
import com.cool.wendao.manager.admin.sys.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@Controller
@RequestMapping("admin/sys/common")
public class CommonController {

    private static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ImgService imgService;



    @Value("${request_image_url}")
    public String requestImageUrl;




    //处理图片上传
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public @ResponseBody
    ResultBean uploadImg(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String filePath = FileUtils.getTmpPath();
        try {
            uploadFile(file.getBytes(), filePath, fileName);
            return new ResultBean(200, null, fileName);
        } catch (Exception ex) {
            logger.error("上传图片出错：", ex);
            return new ResultBean(0, "上传图片出错!", null);
        }
    }


    /**
     * type 1 生成小图，其它不生成小图
     * path 业务地址
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadImgs/{type}/{business}", method = RequestMethod.POST)
    public @ResponseBody
    ResultBean uploadImgs(@PathVariable("business") String business, @PathVariable("type") Integer type, @RequestParam("file") MultipartFile file,
                          HttpServletRequest request) {
        try {
            return new ResultBean(200, null, this.imgService.uploadImg(file, business, type));
        }  catch (ImgException ex) {
            logger.error("上传图片出错：{}", ex.getMessage());
            return new ResultBean(0, ex.getMessage(), null);
        }catch (Exception ex) {
            logger.error("上传图片出错：", ex);
            return new ResultBean(0, "上传图片出错!", null);
        }
    }

    /**
     * type 1 生成小图，其它不生成小图
     * path 业务地址
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadFile/{business}", method = RequestMethod.POST)
    public @ResponseBody
    ResultBean uploadImgs(@PathVariable("business") String business, @RequestParam("file") MultipartFile file,
                          HttpServletRequest request) {
        try {

            return new ResultBean(200, null, imgService.uploadImg(file, business, 0));
        } catch (ImgException ex) {
            logger.error("上传文件出错：", ex);
            return new ResultBean(200, ex.getMessage(), null);
        } catch (Exception ex) {
            logger.error("上传文件出错：", ex);
            return new ResultBean(0, "上传文件出错!", null);
        }
    }

    //处理文件上传
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    ResultBean uploadFile(@RequestParam("file") MultipartFile file,
                          HttpServletRequest request) {
//        String fileName = file.getOriginalFilename();
//        String filePath = FileUtils.getTmpPath();
        try {
//            uploadFile(file.getBytes(), filePath, fileName);
////            return new ResultBean(200, null, fileName);

            return new ResultBean(200, null, imgService.uploadFile(file));
        } catch (ImgException ex) {
            logger.error("上传文件出错：", ex);
            return new ResultBean(200, ex.getMessage(), null);
        }catch (Exception ex) {
            logger.error("上传文件出错：", ex);
            return new ResultBean(0, "上传文件出错!", null);
        }
    }


    @RequestMapping("/tmpImg")
    public void tmpImg(HttpServletResponse response, String imageName) {
        try {
            File imageFile = new File(FileUtils.getTmpPath() + imageName);
            InputStream is = new FileInputStream(imageFile);
            BufferedImage bi = ImageIO.read(is);
            ImageIO.write(bi, "jpg", response.getOutputStream());
        } catch (Exception ex) {
            logger.error("临时图片访问出错：", ex);
        }
    }

    private static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "sendSms", method = RequestMethod.POST)
    public @ResponseBody
    ResultBean sendSms(String tel, Integer type) {
//        try {
//            Integer code = (int) ((Math.random() * 9 + 1) * 1000);
//            int expTime = 5;
//            Integer templateId = null;
//            List<String> params = null;
//            switch (type){
//                case 1://注册
//                    templateId = SmsConstant.ORG_REGISTER_CODE;
//                    params = new ArrayList<>();
//                    params.add(code.toString());
//                    params.add(expTime+"");
//                    break;
//                case 2://忘记密码
//                    templateId = SmsConstant.ORG_REGISTER_CODE;
//                    params = new ArrayList<>();
//                    params.add(code.toString());
//                    params.add(expTime+"");
//                    break;
//            }
//            return messageSendService.send(tel,templateId,params,code.toString(),expTime*60);
//        } catch (Exception ex) {
//            logger.error("短信发送失败：", ex);
            return new ResultBean(0, "短信发送失败，请稍后再试!", null);
//        }
    }

}
