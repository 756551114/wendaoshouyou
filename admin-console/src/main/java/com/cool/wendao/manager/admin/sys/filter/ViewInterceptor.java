package com.cool.wendao.manager.admin.sys.filter;

import com.cool.wendao.admin.params.SysResource;
import com.cool.wendao.admin.params.SysUser;
import com.cool.wendao.manager.admin.sys.utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ViewInterceptor implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		SysUser sysUser = SessionUtils.getUser(httpRequest);
		String contextPath = httpRequest.getContextPath();
		String path = httpRequest.getRequestURI().substring(contextPath.length());
		if(sysUser != null) {
			for(SysResource sysRes : sysUser.getResList()) {
				if(path.equals(sysRes.getResUrl())) {
					request.setAttribute("viewId", sysRes.getResId());
					break;
				}
			}
		}
		chain.doFilter(httpRequest, response);
	}

	@Override
	public void destroy() {
		
	}

}
