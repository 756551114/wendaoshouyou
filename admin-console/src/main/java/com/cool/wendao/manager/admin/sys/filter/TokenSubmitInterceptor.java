package com.cool.wendao.manager.admin.sys.filter;

import com.cool.wendao.admin.core.ResultEnum;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class TokenSubmitInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(TokenSubmitInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        TokenSubmitAnnotation annotation = method.getAnnotation(TokenSubmitAnnotation.class);
        //是否设置了表单token验证
//        if (annotation != null) {
//            boolean needSaveSession = annotation.needSaveToken();
//            String tokenName = annotation.tokenName();
//            //写入token参数
//            if (needSaveSession) {
//                request.getSession().setAttribute(tokenName, makeToken(SessionUtils.getUser(request).getUserId()));
//            }
//            //删除token参数
//            boolean needRemoveSession = annotation.needRemoveToken();
//            if (needRemoveSession) {
//                if (isRepeatSubmit(request, tokenName)) {
//                	writeJson(response, ResultEnum.SUBMIT_TOKEN_FAIL);
//                     return false;
//                }
//                request.getSession(false).removeAttribute(tokenName);
//            }
//        }

//        return true;
        return super.preHandle(request,response,handler);
    }
    public void writeJson(HttpServletResponse response,ResultEnum resultEnum){
		try {
			response.setContentType("application/json;charset=utf-8");
			response.setHeader("Content-Type","application/json");
			response.getWriter()
			.write("{\"sta\":"+resultEnum.getCode()+",\"msg\":\""+resultEnum.getMsg()+"\"}");
			response.getWriter().close();
		} catch (IOException e) {
			logger.error("",e);
		}
	} 
    private boolean isRepeatSubmit(HttpServletRequest request, String tokenName) {
        String serverToken = (String) request.getSession(false).getAttribute(tokenName);
        if (serverToken == null) {
            return true;
        }
        String clientToken = request.getParameter(tokenName);
        if (clientToken == null) {
            return true;
        }
        if (!serverToken.equals(clientToken)) {
            return true;
        }
        return false;
    }
    
    public String makeToken(String userId) {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + userId;
        try {
            return DigestUtils.md5Hex(token);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return System.currentTimeMillis() + "";
    }
}
