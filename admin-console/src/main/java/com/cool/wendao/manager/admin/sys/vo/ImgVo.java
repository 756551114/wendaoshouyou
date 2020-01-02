package com.cool.wendao.manager.admin.sys.vo;

/**
 * 返回前段图片格式封装--兼容UED
 *
 * @author cool
 * 2019年4月5日12:51:59
 */
public class ImgVo implements java.io.Serializable {

    /**
     *  访问路径 初始化为空支付串
     */
    public ImgVo() {
        this.requestImageUrl = "";
    }

    /**
     * 大图地址
     */
    private String bigPath;
    /**
     * 小图地址
     */
    private String minPath;
    /**
     * 标题(文件名)
     */
    private String title;

    /**
     * 访问路径---富文本中返回地址需要完整能访问的图片地址---只提供Set 方法， 具体数据会在土地地址中完整返回
     */
    private String requestImageUrl;


    public String getBigPath() {
        return this.requestImageUrl + this.bigPath;
    }

    public void setBigPath(String bigPath) {
        this.bigPath = bigPath;
    }

    public String getMinPath() {
        return this.requestImageUrl + this.minPath;
    }

    public void setMinPath(String minPath) {
        this.minPath = minPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setRequestImageUrl(String requestImageUrl) {
        this.requestImageUrl = requestImageUrl;
    }
}
