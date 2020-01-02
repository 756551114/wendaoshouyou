package com.cool.wendao.manager.admin.sys.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLogoutHandler implements LogoutHandler {

    private SecurityContextLogoutHandler contextLogoutHandler = new SecurityContextLogoutHandler();

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        contextLogoutHandler.logout(httpServletRequest,httpServletResponse,authentication);
    }
}
