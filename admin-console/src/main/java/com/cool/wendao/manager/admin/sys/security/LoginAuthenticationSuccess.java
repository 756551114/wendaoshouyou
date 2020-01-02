package com.cool.wendao.manager.admin.sys.security;

import com.cool.wendao.admin.params.SysUser;
import com.cool.wendao.manager.admin.sys.utils.SessionUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAuthenticationSuccess implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		SysUser sysUser = (SysUser)authentication.getPrincipal();
		SessionUtils.login(request, sysUser);
		String contentType = "application/json;charset=UTF-8";  
        response.setContentType(contentType);
        PrintWriter out = response.getWriter();  
        out.print("{\"sta\":200,\"msg\":\"登录成功\"}");  
        out.flush();  
        out.close();
	}

}
