package com.cool.wendao.manager.admin.sys.controller;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.params.SysResource;
import com.cool.wendao.admin.server.MgtBaseResourceService;
import com.cool.wendao.manager.admin.sys.constants.SysConstants;
import com.reger.dubbo.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单资源管理
 * @author liuyu
 *
 */
@Controller
@RequestMapping("admin/sys/res")
public class ResController {
	
	private static Logger logger = LoggerFactory.getLogger(ResController.class);
	
	@Inject
	private MgtBaseResourceService mgtBaseResourceService;
	
	@RequestMapping("res_index")
	public void res_index(){
		
	}
	
	@RequestMapping("res_data_list")
	public @ResponseBody
	MgtPageBean<SysResource> res_data_list(String resName, Integer orgType, MgtPageBean<SysResource> pageBean){
		return mgtBaseResourceService.getResourcesByPage(resName,orgType,pageBean);
	}
	
	@RequestMapping(value="res_add",method=RequestMethod.GET)
	public void res_add_get(Model model){
		model.addAttribute("typeResList", mgtBaseResourceService.getAllResourcesByType(SysConstants.MENU,0));
	}

	@RequestMapping(value="getAllResources",method=RequestMethod.POST)
	public @ResponseBody
	ResultBean getAllResources(Integer orgType){
		try {
			List<SysResource> sysResources = mgtBaseResourceService.getAllResourcesByType(SysConstants.MENU,orgType);
			return new ResultBean(200,null,sysResources);
		}catch(Exception ex) {
			logger.error("根据机构类型获取资源出错：",ex);
			return new ResultBean(0,"根据机构类型获取资源出错!",null);
		}
	}
	
	@RequestMapping(value="res_add",method=RequestMethod.POST)
	public @ResponseBody ResultBean res_add_post(SysResource sysResource){
		try {
			mgtBaseResourceService.addSysResource(sysResource);
			return new ResultBean(200,null,null);
		}catch(Exception ex) {
			logger.error("新增资源出错：",ex);
			return new ResultBean(0,"新增资源出错!",null);
		}
	}
	
	@RequestMapping(value="res_edit",method=RequestMethod.GET)
	public void res_edit_get(Model model,String resId){
		SysResource sysResource = mgtBaseResourceService.getResourcesById(resId);
		model.addAttribute("sysRes", sysResource);
		model.addAttribute("typeResList", mgtBaseResourceService.getAllResourcesByType(SysConstants.MENU,sysResource.getOrgType()));
	}
	
	@RequestMapping(value="res_edit",method=RequestMethod.POST)
	public @ResponseBody ResultBean res_edit_post(SysResource sysResource){
		try {
			mgtBaseResourceService.updateSysResource(sysResource);
			return new ResultBean(200,null,null);
		}catch(Exception ex) {
			logger.error("更新资源出错：",ex);
			return new ResultBean(0,"更新资源出错!",null);
		}
	}
	
	@RequestMapping("res_del")
	public @ResponseBody ResultBean res_del(String resId){
		try {
			mgtBaseResourceService.delSysResourceByResId(resId);
			return new ResultBean(200,null,null);
		}catch(Exception ex) {
			logger.error("删除资源出错：",ex);
			return new ResultBean(0,"删除资源出错!",null);
		}
	} 

}
