package com.dhcc.admin.sys.security;

import java.io.Serializable;

/**
 * 权限资源实体类
 */
public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id; // 菜单ID

	private Integer parentId; // 父级ID

	private String name; // 菜单名字

	private Integer orderNum; // 排列顺序

	private String url; // 链接地址

	private String img; // 菜单图标

	private String buttontype; // 按钮类型，无表示菜单

	private Integer son; // 子级菜单个数

	private String sonurls; // 子菜单的连接串，用于菜单，2017-02-16 奚渭雄添加

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getButtontype() {
		return buttontype;
	}

	public void setButtontype(String buttontype) {
		this.buttontype = buttontype;
	}

	public Integer getSon() {
		return son;
	}

	public void setSon(Integer son) {
		this.son = son;
	}

	public String getSonurls() {
		return sonurls;
	}

	public void setSonurls(String sonurls) {
		this.sonurls = sonurls;
	}
}
