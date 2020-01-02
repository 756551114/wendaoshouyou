package com.cool.wendao.manager.admin.sys.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAuthenticationFailure implements AuthenticationFailureHandler{
	private static final Logger logger = LoggerFactory.getLogger(LoginAuthenticationFailure.class);
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter printOut = response.getWriter();
		try
		{
			//验证码错误
			if(exception instanceof VerifyCodeException){
				printOut.write("{\"sta\":500,\"msg\":\"验证码错误\"}");
			}else if(exception instanceof UsernameNotFoundException){
				printOut.write("{\"sta\":500,\"msg\":\"该用户名不存在\"}");
			}else if(exception instanceof DisabledException){
				printOut.write("{\"sta\":500,\"msg\":\"对不起，你的账号已被禁用，如有问题请联系管理员！\"}");
			}else if(exception instanceof BadCredentialsException){
				printOut.write("{\"sta\":500,\"msg\":\"密码错误\"}");
			}else if(exception instanceof LockedException){
				printOut.write("{\"sta\":500,\"msg\":\"当前用户账号已经被删除\"}");
			}else if(exception instanceof SessionAuthenticationException){
				printOut.write("{\"sta\":500,\"msg\":\"当前用户已登陆,登陆失败\"}");
			}//其他异常
			else if(exception instanceof org.springframework.security.authentication.AuthenticationServiceException){
				printOut.write("{\"sta\":500,\"msg\":\""+exception.getMessage()+"\"}");
			}
		}catch(Exception ex){
			logger.error("onAuthenticationFailure", ex);
		}finally{
			printOut.flush();
			printOut.close();
		}
	}
}
