package com.dhcc.admin.sys.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class SpringUtils implements ApplicationContextAware {

	 private static ApplicationContext applicationContext;
	 
	    @Override
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	    	SpringUtils.applicationContext = applicationContext;
	    }
	 
	    public static <T> T getBean(Class<T> cls) {
	        if (applicationContext == null) {
	            throw new RuntimeException("applicationContext注入失败");
	        }
	        return applicationContext.getBean(cls);
	    }
	 
	    public static Object getBean(String name) {
	        if (applicationContext == null) {
	            throw new RuntimeException("applicationContext注入失败");
	        }
	        return applicationContext.getBean(name);
	    }
	 
	    public static <T> T getBean(String name, Class<T> cls) {
	        if (applicationContext == null) {
	            throw new RuntimeException("applicationContext注入失败");
	        }
	        return applicationContext.getBean(name, cls);
	    }
	 
	    public static HttpServletRequest getRequest() {
	        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
	            .getRequestAttributes();
	        return requestAttributes == null ? null : requestAttributes.getRequest();
	    }

}
