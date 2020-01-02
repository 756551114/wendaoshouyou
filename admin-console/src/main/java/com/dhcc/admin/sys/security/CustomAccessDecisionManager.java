package com.dhcc.admin.sys.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dhcc.admin.sys.constants.SysConstants;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		 if(CollectionUtils.isEmpty(configAttributes)) {    
             return;    
         }
		 for(GrantedAuthority ga : authentication.getAuthorities()) {//如果是超级管理员则跳过权限验证
			 if(ga.getAuthority().equals(SysConstants.SUPER_ADMIN_JOB_ID)){
            	 return; 
             }
		 }
         //所请求的资源拥有的权限(一个资源对多个权限)    
         Iterator<ConfigAttribute> its = configAttributes.iterator();    
         while(its.hasNext()) {
             ConfigAttribute configAuthtication = its.next();    
             //访问所请求资源所需要的权限    
             String needPermission = configAuthtication.getAttribute();
             //用户所拥有的权限authentication    
             for(GrantedAuthority ga : authentication.getAuthorities()) { 
                 if(needPermission.equals(ga.getAuthority())) {    
                     return;    
                 }
             }    
         }    
         //没有权限    会跳转到login.jsp页面  
         throw new AccessDeniedException("该用户没有权限访问");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
