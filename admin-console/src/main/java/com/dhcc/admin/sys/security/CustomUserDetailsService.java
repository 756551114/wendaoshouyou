package com.dhcc.admin.sys.security;

import com.cool.wendao.admin.params.Authority;
import com.cool.wendao.admin.params.SysUser;
import com.cool.wendao.admin.server.MgtBaseResourceService;
import com.cool.wendao.admin.server.MgtBaseUserService;
import com.dhcc.admin.sys.constants.SysConstants;
import com.reger.dubbo.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Inject
	private MgtBaseUserService mgtBaseUserService;

	@Inject
	private MgtBaseResourceService mgtBaseResourceService;
	
	private static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String loginName)
			throws UsernameNotFoundException {
		try {
			SysUser loginUser = mgtBaseUserService.getUserByLoginName(loginName,SysConstants.PT_ID);
			if(loginUser == null){
				throw new UsernameNotFoundException("该用户名不存在");
			}
			if(loginUser!=null&&"N".equals(loginUser.getOrgHasEnabled())){
				throw new DisabledException("对不起，你的账号已被禁用，如有问题请联系管理员！");
			}
			if(SysConstants.SUPER_ADMIN_ID.equals(loginUser.getUserId())) {//超级管理员
				loginUser.setResList(mgtBaseResourceService.getAllResourcesTree());
				loginUser.getAuthorityList().add(new Authority(SysConstants.SUPER_ADMIN_JOB_ID));
			}else {//非超级管理员
				loginUser.setResList(mgtBaseResourceService.getMyResourcesTree(loginUser.getUserId()));
				List<String> jobIdList = mgtBaseUserService.getJobIdsByUserId(loginUser.getUserId());
				for(String jobId : jobIdList) {
					loginUser.getAuthorityList().add(new Authority(jobId));
				}
			}
			return loginUser;
		} catch (Exception e) {
			logger.error("登录失败",e);
			if (e instanceof UsernameNotFoundException ) {
				throw new UsernameNotFoundException("该用户名不存在");
			}else if ( e instanceof DisabledException) {
				throw new DisabledException("对不起，你的账号已被禁用，如有问题请联系管理员！");
			}else {
				throw new DisabledException("系统繁忙,稍后再试");
			}
		}
		
	}
}
