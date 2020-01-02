package com.dhcc.admin.sys.controller;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.core.SmsConstant;
import com.cool.wendao.admin.params.SysUser;
import com.cool.wendao.admin.params.UpdatePwd;
import com.cool.wendao.admin.server.MessageSendService;
import com.cool.wendao.admin.server.MgtBaseUserService;
import com.dhcc.admin.sys.constants.SysConstants;
import com.dhcc.admin.sys.security.SecurityMetadataSource;
import com.dhcc.admin.sys.utils.SessionUtils;
import com.reger.dubbo.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统用户管理
 * @author liuyu
 *
 */
@Controller
@RequestMapping("admin/sys/user")
public class SysUserController {
	
	private static Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Inject
	private MgtBaseUserService mgtBaseUserService;

	@Autowired
	private SecurityMetadataSource securityMetadataSource;

	@Inject
	private MessageSendService messageSendService;

	@RequestMapping("user_index")
	public void user_index(HttpServletRequest request,Model model) {
		model.addAttribute("jobList", mgtBaseUserService.getJobsByOrgId(SessionUtils.getUser(request).getOrgId()));
	}
	
	@RequestMapping("user_data_list")
	public @ResponseBody
	MgtPageBean<SysUser> res_data_list(HttpServletRequest request, SysUser param, MgtPageBean<SysUser> pageBean){
		param.setOrgId(SessionUtils.getUser(request).getOrgId());
		return mgtBaseUserService.getSysUsersByPage(param,pageBean);
	}
	
	@RequestMapping(value="user_add",method=RequestMethod.GET)
	public void user_add_get(HttpServletRequest request,Model model,String userId){
		try {
			model.addAttribute("jobList", mgtBaseUserService.getJobsByOrgId(SessionUtils.getUser(request).getOrgId()));
			model.addAttribute("initPwd", SysConstants.RAWPWD);
		}catch(Exception ex) {
			logger.error("进入新增系统用户界面出错：",ex);
		}
	}
	
	@RequestMapping(value="user_add",method=RequestMethod.POST)
	public @ResponseBody ResultBean user_add_post(HttpServletRequest request,SysUser sysUser){
		try {
			int isExists = mgtBaseUserService.checkLoginName(sysUser.getLoginName(),SysConstants.PT_ID);
			if(isExists > 0) {
				return new ResultBean(0, "登录名重复，请重新输入!",null);
			}
			mgtBaseUserService.addSysUser(SessionUtils.getUser(request), sysUser);
			return new ResultBean(200, null,null);
		}catch(Exception ex) {
			logger.error("新增系统用户出错：",ex);
			return new ResultBean(0, "新增系统用户出错!",null);
		}
	}
	
	@RequestMapping("user_del")
	public @ResponseBody ResultBean user_del(String userId) {
		try {
			mgtBaseUserService.delSysUser(userId);
			return new ResultBean(200, null,null);
		}catch(Exception ex) {
			logger.error("删除系统用户出错：",ex);
			return new ResultBean(0, "删除系统用户出错!",null);
		}
	}
	
	@RequestMapping(value="user_edit",method=RequestMethod.GET)
	public void user_edit_get(HttpServletRequest request,Model model,String userId){
		try {
			model.addAttribute("sysUser", mgtBaseUserService.getSysUserById(userId));
			model.addAttribute("jobList", mgtBaseUserService.getJobsByOrgId(SessionUtils.getUser(request).getOrgId()));
		}catch(Exception ex) {
			logger.error("进入修改系统用户界面出错：",ex);
		}
	}

	@RequestMapping(value="user_view",method=RequestMethod.GET)
	public void user_view_get(HttpServletRequest request,Model model,String userId){
		try {
			model.addAttribute("sysUser", mgtBaseUserService.getSysUserById(userId));
			model.addAttribute("jobList", mgtBaseUserService.getAllJobs());
		}catch(Exception ex) {
			logger.error("进入系统用户详情界面出错：",ex);
		}
	}
	
	@RequestMapping(value="user_edit",method=RequestMethod.POST)
	public @ResponseBody ResultBean user_edit_post(SysUser sysUser) {
		try {
			mgtBaseUserService.updateSysUser(sysUser);
			return new ResultBean(200, null,null);
		}catch(Exception ex) {
			logger.error("编辑系统用户出错：",ex);
			return new ResultBean(0, "编辑系统用户出错!",null);
		}
	}

	@RequestMapping("forget_pwd")
	public void forget_pwd() {

	}

	@RequestMapping(value="forgetPwd",method=RequestMethod.POST)
	public @ResponseBody
	ResultBean forgetPwd(String tel, String code, UpdatePwd updatePwd) {
		try {
			if(!updatePwd.getPassword().equals(updatePwd.getRepassword())) {
				return new ResultBean(0, "重置密码失败，两次输入的密码不一致，请检查!", null);
			}
			ResultBean resultBean = messageSendService.validate(tel, SmsConstant.ORG_REGISTER_CODE,code);
			if(resultBean.getSta()==200){
				int count = mgtBaseUserService.updateUserPwd(null,tel,updatePwd.getPassword());
				if(count>0){
					return new ResultBean(200, null, null);
				}else{
					return new ResultBean(0, "用户不存在!", null);
				}
			}else{
				return new ResultBean(0, resultBean.getMsg(), null);
			}
		}catch(Exception ex) {
			logger.error("重置密码失败：",ex);
			return new ResultBean(0, "重置密码失败，请稍后再试!", null);
		}
	}

	@RequestMapping("register")
	public void register() {

	}

	@RequestMapping(value="registerPost",method=RequestMethod.POST)
	public @ResponseBody
	ResultBean registerPost(String tel,String code,UpdatePwd updatePwd) {
		try {
			ResultBean resultBean = messageSendService.validate(tel, SmsConstant.ORG_REGISTER_CODE,code);
			if(resultBean.getSta()==200){
				int count = mgtBaseUserService.checkLoginName(tel,SysConstants.PT_ID);
				if(count>0){
					return new ResultBean(0, "注册失败，已存在相同手机号!", null);
				}
				SysUser addSysUser = new SysUser();
				addSysUser.setLoginName(tel);
				addSysUser.setHasEnabled("Y");
				addSysUser.setLoginPwd(updatePwd.getPassword());
				addSysUser.setContactPhone(tel);
				mgtBaseUserService.addSpecialSysUser(null,100,addSysUser);
				securityMetadataSource.refreshResourceDefine();
				return new ResultBean(200, null, null);
			}else{
				return new ResultBean(0, resultBean.getMsg(), null);
			}
		}catch(Exception ex) {
			logger.error("注册失败：",ex);
			return new ResultBean(0, "注册失败，请稍后再试!", null);
		}
	}

}
