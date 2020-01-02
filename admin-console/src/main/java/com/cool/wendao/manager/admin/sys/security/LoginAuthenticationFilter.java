package com.cool.wendao.manager.admin.sys.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private boolean postOnly = true;

    private SessionRegistry sessionRegistry;

    public LoginAuthenticationFilter(SessionRegistry sessionRegistry) {
        this.setAuthenticationSuccessHandler(new LoginAuthenticationSuccess());
        this.setAuthenticationFailureHandler(new LoginAuthenticationFailure());
        this.setAuthenticationManager(getAuthenticationManager());
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String verifyCode = request.getParameter("verifyCode").toUpperCase();
        if(!"123206B218AD4E6EAC0E3030D27D18FF".equals(verifyCode)){//特殊处理，用于商户注册自动登录
            if(request.getSession() != null && request.getSession().getAttribute("verifyCode") != null){
                String serverVerifyCode = request.getSession().getAttribute("verifyCode").toString();
                if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(serverVerifyCode)) {
                    throw new VerifyCodeException("验证码错误");
                }
            }else{
                throw new VerifyCodeException("验证码错误");
            }
        }
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = this.obtainUsername(request);
            String password = this.obtainPassword(request);
            if (username == null) {
                username = "";
            }

            if (password == null) {
                password = "";
            }

            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            //用户名密码验证通过后,注册session
            sessionRegistry.registerNewSession(request.getSession().getId(),authRequest.getPrincipal());
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }
}