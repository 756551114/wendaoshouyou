package com.cool.wendao.admin.core;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页工具
 * @author liuyu
 * @param <T>
 */
public class MgtPageBean<T> implements Serializable {

    private static final long serialVersionUID = -4363404680080569788L;
    private int code=200;//状态码  根据蔡九银的要求改成 200 正常

    private int page = 1;//当前页

    private int pageSize = 20;//数据量/页

    private Integer count;//总数

    private String msg;//返回消息

    private String params;//接入传入查询条件
    private Map<String, Object> where;//sql处理查询条件

    private List<T> data;//数据列表

    public MgtPageBean(){
    }

    public MgtPageBean(List<T> data, int count){
        this.code = 200;
        this.count = count;
        this.data = data;
    }

    public MgtPageBean(int code) {
        this.code = code;
    }
    public MgtPageBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public MgtPageBean(ResultEnum error) {
        this.code = error.getCode();
        this.msg = error.getMsg();
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        if(count == null) {
            this.count = 0;
        }else {
            this.count = count;
        }
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public String getParams() {
        return params;
    }
    public void setParams(String params) {
        this.params = params;
    }
    public Map<String, Object> getWhere() {
        return where;
    }
    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }
    public int getStartSize() {
        return (page - 1) * pageSize;
    }

}

