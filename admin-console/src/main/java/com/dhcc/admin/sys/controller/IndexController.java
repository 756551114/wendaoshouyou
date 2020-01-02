package com.dhcc.admin.sys.controller;

import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.params.SysUser;
import com.cool.wendao.admin.params.UpdatePwd;
import com.cool.wendao.admin.server.MgtBaseUserService;
import com.dhcc.admin.sys.utils.SessionUtils;
import com.reger.dubbo.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class IndexController {

	private static Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	@Inject
	private MgtBaseUserService mgtBaseUserService;

	@RequestMapping("index")
	public void index(){
		
	}
	
	@RequestMapping(value="updatePwd",method=RequestMethod.GET)
	public void updatePwd_get() {
		
	}
	
	@RequestMapping(value="updatePwd",method=RequestMethod.POST)
	public @ResponseBody
	ResultBean updatePwd_post(HttpServletRequest request, UpdatePwd updatePwd) {
		try {
			SysUser sysUser = SessionUtils.getUser(request);
			if(!updatePwd.getPassword().equals(updatePwd.getRepassword())) {
				return new ResultBean(0, "修改密码失败，两次输入的密码不一致，请检查!", null);
			}
			PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
			if(pwdEncoder.matches(updatePwd.getPassword(), sysUser.getLoginPwd())) {
				return new ResultBean(0, "修改密码失败，输入新密码与旧密码不能相同!", null);
			}
			if(!pwdEncoder.matches(updatePwd.getOldPassword(), sysUser.getLoginPwd())) {
				return new ResultBean(0, "修改密码失败，旧密码输入错误!", null);
			}
			sysUser.setLoginPwd(pwdEncoder.encode(updatePwd.getPassword()));
			mgtBaseUserService.updatePwd(sysUser);
			return new ResultBean(200, null, null);
		}catch(Exception ex) {
			logger.error("修改密码失败：",ex);
			return new ResultBean(0, "修改密码失败，请稍后再试!", null);
		}
	}

	@RequestMapping(value="userInfo",method=RequestMethod.GET)
	public void userInfo_get(HttpServletRequest request,Model model) {
		try {
			SysUser user = SessionUtils.getUser(request);
			model.addAttribute("sysUser", mgtBaseUserService.getSysUserById(user.getUserId()));
			model.addAttribute("jobList", mgtBaseUserService.getAllJobs());
		}catch(Exception ex) {
			logger.error("进入用户基本资料界面出错：",ex);
		}
	}

	@RequestMapping("console")
	public void console(){
		
	}

}
