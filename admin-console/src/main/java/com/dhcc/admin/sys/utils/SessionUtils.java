package com.dhcc.admin.sys.utils;

import com.cool.wendao.admin.params.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	
	private static final String LOGIN_SESSION_KEY = "loginUser";
	
	/**
	 * 用户登录
	 * @param request
	 * @param sysUser
	 */
	public static void login(HttpServletRequest request,SysUser sysUser) {
		HttpSession session=request.getSession(true);
		session.setAttribute(LOGIN_SESSION_KEY, sysUser);
	}
	
	/**
	 * 获取登录用户信息
	 * @param request
	 * @return
	 */
	public static SysUser getUser(HttpServletRequest request) {
		return (SysUser)request.getSession().getAttribute(LOGIN_SESSION_KEY);
	}

}
