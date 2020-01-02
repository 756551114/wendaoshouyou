package com.cool.wendao.manager.admin.sys.controller;

import com.cool.wendao.admin.core.MgtPageBean;
import com.cool.wendao.admin.core.ResultBean;
import com.cool.wendao.admin.params.SysJob;
import com.cool.wendao.admin.server.MgtBaseJobService;
import com.cool.wendao.manager.admin.sys.security.SecurityMetadataSource;
import com.cool.wendao.manager.admin.sys.utils.SessionUtils;
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
 * 岗位管理
 * @author liuyu
 *
 */
@Controller
@RequestMapping("admin/sys/job")
public class JobController {
	
	private static Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Inject
	private MgtBaseJobService mgtBaseJobService;

	@Autowired
	private SecurityMetadataSource securityMetadataSource;
	
	@RequestMapping(value="job_index",method=RequestMethod.GET)
	public void job_index(){
		
	}
	
	@RequestMapping("job_data_list")
	public @ResponseBody
	MgtPageBean<SysJob> job_data_list(HttpServletRequest request, MgtPageBean<SysJob> pageBean){
		return mgtBaseJobService.getJobsByPage(SessionUtils.getUser(request), pageBean);
	}
	
	@RequestMapping(value="job_add",method=RequestMethod.GET)
	public void job_add_get() {
		
	}
	
	@RequestMapping(value="job_add",method=RequestMethod.POST)
	public @ResponseBody ResultBean job_add_post(HttpServletRequest request,SysJob sysJob) {
		try {
			int result = mgtBaseJobService.checkJobName(null,sysJob.getJobName());
			if(result>0){
				return new ResultBean(0, "岗位名重复，请重新输入!",null);
			}
			mgtBaseJobService.addJob(SessionUtils.getUser(request), sysJob);
			securityMetadataSource.refreshResourceDefine();
			return new ResultBean(200, null,null);
		}catch(Exception ex) {
			logger.error("新增岗位出错：",ex);
			return new ResultBean(0, "新增岗位出错!",null);
		}
	}
	
	@RequestMapping(value="job_edit",method=RequestMethod.GET)
	public void job_edit_get(Model model,String jobId) {
		model.addAttribute("sysJob", mgtBaseJobService.getJobByJobId(jobId));
	}

	@RequestMapping(value="job_view",method=RequestMethod.GET)
	public void job_view_get(Model model,String jobId) {
		model.addAttribute("sysJob", mgtBaseJobService.getJobByJobId(jobId));
	}
	
	@RequestMapping(value="job_edit",method=RequestMethod.POST)
	public @ResponseBody ResultBean job_edit_post(SysJob sysJob) {
		try {
			int result = mgtBaseJobService.checkJobName(sysJob.getJobId(),sysJob.getJobName());
			if(result>0){
				return new ResultBean(0, "岗位名重复，请重新输入!",null);
			}
			mgtBaseJobService.updateJob(sysJob);
			securityMetadataSource.refreshResourceDefine();
			return new ResultBean(200, null,null);
		}catch(Exception ex) {
			logger.error("编辑岗位出错：",ex);
			return new ResultBean(0, "编辑岗位出错!",null);
		}
	}

	@RequestMapping("job_2_res")
	public @ResponseBody ResultBean job2res(HttpServletRequest request,String jobId,boolean disabled) {
		return mgtBaseJobService.getJob2ResByJobId(SessionUtils.getUser(request),jobId,disabled);
	}
	
	@RequestMapping("job_del")
	public @ResponseBody ResultBean job_del(String jobId) {
		try {
			String flag = mgtBaseJobService.delJob(jobId);
			if("exist".equals(flag)){
				return new ResultBean(0, "该岗位下存在员工不能删除!",null);
			}
			return new ResultBean(200, null,null);
		}catch(Exception ex) {
			logger.error("删除岗位出错：",ex);
			return new ResultBean(0, "删除岗位出错!",null);
		}
	}

}
