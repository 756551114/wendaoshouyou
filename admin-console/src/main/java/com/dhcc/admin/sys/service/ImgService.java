package com.dhcc.admin.sys.service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.cool.wendao.admin.core.FileVo;
import com.dhcc.admin.sys.exception.ImgException;
import com.dhcc.admin.sys.vo.ImgVo;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImgService {

    private static Logger logger = LoggerFactory.getLogger(ImgService.class);

//    private FastDFSClient fastDFSClient = new FastDFSClient();


    //文件限制大小
    private static final int FEIL_SIZE = 10;
    //图片最大
    private static final int IMG_MAX_SIZE = 2;
    //压缩比例
    private static final float IMG_PROPORTION = 0.55f;
    //单位
    private static final String FEIL_UNIT = "M";


    public FileVo uploadFile(MultipartFile file) throws Exception {
        boolean k = checkFileSize(file.getSize(), FEIL_SIZE, FEIL_UNIT);
        if (k) {
            throw new ImgException("大小超出限制");
        }
        FileVo fileVo = new FileVo();
        // 上传到服务器
//        String filepath = fastDFSClient.uploadFileWithMultipart(file);
//        fileVo.setFileName(file.getOriginalFilename());
//        fileVo.setFilePath(filepath);
//        fileVo.setFileType(FastDFSClient.getFilenameSuffix(file.getOriginalFilename()));
        // 设置访文件的Http地址. 有时效性.
//        String token = FastDFSClient.getToken(filepath, FastDfsConfig.getHttpSecretKey());
//        fileVo.setToken(token);
//        fileVo.setHttpUrl(FastDfsConfig.getFileServerAddr() + "/" + filepath + "?" + token);
        return fileVo;
    }

    public FileVo uploadFile(byte[] bytes, String name) throws Exception {
        FileVo fileVo = new FileVo();
//        // 上传到服务器
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//        boolean k = checkFileSize((long) inputStream.available(), FEIL_SIZE, FEIL_UNIT);
//        if (k) {
//            throw new ImgException("大小超出限制");
//        }
//        String filepath = fastDFSClient.upload(inputStream, name, null);
//        fileVo.setFileName(name);
//        fileVo.setFilePath(filepath);
//        fileVo.setFileType(FastDFSClient.getFilenameSuffix(name));
//        // 设置访文件的Http地址. 有时效性.
//        String token = FastDFSClient.getToken(filepath, FastDfsConfig.getHttpSecretKey());
//        fileVo.setToken(token);
//        fileVo.setHttpUrl(FastDfsConfig.getFileServerAddr() + "/" + filepath + "?" + token);
        return fileVo;
    }


    /**
     * 保存图片，保存为一张小图和大图
     *
     * @param file
     * @return
     * @throws Exception
     */
    public ImgVo uploadImg(MultipartFile file, String business, Integer type) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = file.getInputStream();
        ImgVo imgVo = new ImgVo();
        try {
            if (null != file) {
                String originalFileName = file.getOriginalFilename();
                originalFileName = originalFileName.replaceAll("\\/|\\/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_");
                FileVo fileVo = null;
                long size = file.getSize();
                byte[] bytes = toByteArray(inputStream);
                while (true) {
                    boolean k = checkFileSize(size, IMG_MAX_SIZE, FEIL_UNIT);
                    if (k) {
                        ByteArrayInputStream inputStreamT = null;
                        try {
                            outputStream = new ByteArrayOutputStream();
                            Thumbnails.of(file.getInputStream()).scale(IMG_PROPORTION).toOutputStream(outputStream);
                            bytes = outputStream.toByteArray();
                            inputStreamT = new ByteArrayInputStream(bytes);
                            size = (long) inputStreamT.available();
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        } finally {
                            try {
                                if (inputStreamT != null) {
                                    inputStreamT.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        break;
                    }
                }
                fileVo = uploadFile(bytes, originalFileName);
                imgVo.setBigPath(fileVo.getFilePath());
                imgVo.setTitle(originalFileName);
                if (type != null && type == 1) {
                    try {
                        outputStream = new ByteArrayOutputStream();
                        Thumbnails.of(file.getInputStream()).scale(IMG_PROPORTION).toOutputStream(outputStream);
                        fileVo = uploadFile(outputStream.toByteArray(), originalFileName);
                        imgVo.setMinPath(fileVo.getFilePath());
                    } catch (Exception e) {
                        logger.error("保存小图异常", e);
                        throw new Exception("保存小图异常");
                    }
                }
            }
        } catch (Exception e) {
            throw e;
//            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }
        return imgVo;
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }


    /**
     * 超出限制返回true
     *
     * @param len
     * @param size
     * @param unit
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return true;
        }
        return false;
    }
}
