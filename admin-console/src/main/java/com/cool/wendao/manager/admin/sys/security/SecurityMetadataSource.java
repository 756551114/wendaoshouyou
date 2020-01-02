package com.cool.wendao.manager.admin.sys.security;

import com.cool.wendao.admin.params.Job2Resource;
import com.cool.wendao.admin.server.MgtBaseJobService;
import com.reger.dubbo.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Component
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource,InitializingBean{
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityMetadataSource.class);
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Inject
	private MgtBaseJobService mgtBaseJobService;
    
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {  
        return null;  
    }  
  
    @Override
    public boolean supports(Class<?> clazz) {
        return true;  
    }  

    private void loadResourceDefine(){
    	try
    	{
           resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
           List<Job2Resource> job2ResList = mgtBaseJobService.getAllJob2Res();
           Collection<ConfigAttribute> configAttributes = null;
           for(Job2Resource job2Res : job2ResList) {
        	   configAttributes = resourceMap.get(job2Res.getResUrl());
        	   if(CollectionUtils.isEmpty(configAttributes)) {
        		   configAttributes = new ArrayList<ConfigAttribute>();
        		   resourceMap.put(job2Res.getResUrl(), configAttributes);
        	   }
        	   boolean isRepeat = false;
        	   for(ConfigAttribute configAttribute : configAttributes) {
        		   if(configAttribute.getAttribute().equals(job2Res.getJobId())) {
        			   isRepeat = true;
        			   break;
        		   }
        	   }
        	   if(!isRepeat) {
        		   configAttributes.add(new SecurityConfig(job2Res.getJobId()));
        	   }
           }
    	}catch(Exception ex){
    		logger.error("loadResourceDefine", ex);
    	}
    }  
    
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {  
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if(resourceMap == null) {  
            loadResourceDefine();  
        }
        return resourceMap.get(requestUrl);  
    }
    
	@Override
	public void afterPropertiesSet() throws Exception {
		this.loadResourceDefine();
	}
	
	
	/**
	 * 重新刷新资源路径-角色权限配置
	 */
	public void refreshResourceDefine(){
    	this.loadResourceDefine();	
    }
}
