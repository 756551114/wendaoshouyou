package com.cool.wendao.admin.core;


import java.io.Serializable;

/**
 * @author caijy
 * @version V1.0
 * @Description 返回结果
 * @date 2018年5月11日 下午2:54:06
 */
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = -1284667825112335040L;
    private int sta;//状态
    private String msg;//消息
    private T data;    //数据集合

    public ResultBean() {
        super();
    }

    public ResultBean(int sta, String msg, T data) {
        super();
        this.sta = sta;
        this.msg = msg;
        this.data = data;
    }

    public ResultBean(int sta, String msg) {
        this(sta, msg, null);
    }

    public ResultBean(ResultEnum resultEnum) {
        this(resultEnum.getCode(), resultEnum.getMsg());
    }

    public ResultBean(ResultEnum resultEnum, T data) {
        this(resultEnum.getCode(), resultEnum.getMsg(), data);
    }

    public static ResultBean SUCCESS() {
        return new ResultBean(ResultEnum.SUCCESS);
    }

    /**
     * <p>Description:是否成功，默认跟ResultEnum.SUCCESS进行比较 </p>
     *
     * @return
     */
    public boolean isSuccess() {
        return equal(ResultEnum.SUCCESS);
    }

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return sta;
    }

    public void setCode(int code) {
        this.sta = code;
    }

    /**
     * <p>Description: 判断是否相等，根据resultEnum.getCode()和sta进行比对判断</p>
     *
     * @param resultEnum 结果枚举
     * @return
     */
    public boolean equal(ResultEnum resultEnum) {
        if (resultEnum != null && resultEnum.getCode() == sta) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BaseVo [sta=" + sta + ", msg=" + msg + "]";
    }
}