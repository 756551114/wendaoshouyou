package com.cool.wendao.manager.admin.sys.security;

import com.cool.wendao.manager.admin.sys.utils.SessionUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ExpiredSessionFilter
 * @Description: session过期过滤器
 * @author fangbb
 * 2019-02-01
 */
public class ExpiredSessionFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String contextPath = request.getContextPath();
        String path = request.getRequestURI().substring(contextPath.length());
        if(!"/admin/sys/user/forget_pwd".equals(path)&&!"/admin/sys/user/forgetPwd".equals(path)
                &&!"/admin/sys/common/sendSms".equals(path)&&!"/admin/sys/user/register".equals(path)&&!"/admin/sys/user/registerPost".equals(path)){
            Object obj = SessionUtils.getUser(request);
            if(obj == null) {
                //如果是ajax请求响应头会有，x-requested-with
                if(request.getHeader("x-requested-with") != null &&
                        request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
                }
            }
        }
        chain.doFilter(request, response);
    }

}