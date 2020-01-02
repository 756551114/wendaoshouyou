package com.cool.wendao.admin.core;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileVo implements Serializable {
    private static final long serialVersionUID = 6650915014178295837L;
    //ApiModelProperty(value="文件名", example="1.jpg")
    private String fileName;
    //@ApiModelProperty(value="文件路径", example="group1/M00/00/00/rB4AEVytcE2AUIJZAABeXBvt8zE690.jpg")
    private String filePath;
    //@ApiModelProperty(value="文件类型", example="jpg")
    private String fileType;
    //@ApiModelProperty(value="访问文件的时效性", example="token=97471ceae622471022e918246d21aad8&ts=1554870352")
    private String token;
    //@ApiModelProperty(value="文件http请求地址", example="http://94.191.95.11:8080/group1/M00/00/00/rB4AEVytcE2AUIJZAABeXBvt8zE690.jpg?token=97471ceae622471022e918246d21aad8&ts=1554870352")
    private String httpUrl;


}
