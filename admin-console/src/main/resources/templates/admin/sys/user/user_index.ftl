<#include "../../../layout.ftl" >
<@head title="系统用户管理" />
<body>
	<div class="layui-fluid">   
		<div class="layui-card">
			<div class="layui-form layui-card-header layuiadmin-card-header-auto">
				<div class="layui-form-item">
					<div class="layui-inline">
						姓名
					</div>
					<div class="layui-inline">
						<input type="text" name="nickname" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-inline">
						手机号
					</div>
					<div class="layui-inline">
						<input type="text" name="contactPhone" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-inline">
						岗位
					</div>
					<div class="layui-inline">
						<div class="layui-col-md12">
							<select name="jobIds" lay-verify="jobIds" lay-verType="tips" xm-select="jobSelect" xm-select-max="1">
								<option value="-1">全部</option>
								<#list jobList as job>
									<option value="${job.jobId}">${job.jobName}</option>
								</#list>
							</select>
						</div>
					</div>
					<div class="layui-inline">
						<button class="layui-btn" lay-submit lay-filter="search_sys_user">
							查询
						</button>
					</div>
				</div>
			</div>
			<div class="layui-card-body">
				<#list Session.loginUser.resList as sysRes>
					<#if sysRes.pId?? && (sysRes.pId == (Request.viewId)!"") && sysRes.perms == "add">
				        <div style="padding-bottom: 10px;text-align:right;">
							<button class="layui-btn" id="add_user">
								<i class="layui-icon">&#xe608;</i> 添加
							</button>
				        </div>
		        	</#if>
		        </#list>
		        <table id="tbl_sys_user" lay-filter="tbl_sys_user">
		        	
		        </table>  
		        <script type="text/html" id="sys_user_toolbar">
					<a class="layui-btn layui-btn-xs" lay-event="view"><i class="layui-icon layui-icon-search"></i>查看</a>
			        <#list Session.loginUser.resList as sysRes>
		        		<#if sysRes.pId?? && (sysRes.pId == (Request.viewId)!"") && sysRes.perms == "update">
							<#--{{# if(d.hasDefault=="N"){ }}-->
		          				<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
						<#--{{{# } }}-->
		          		</#if>
		          		<#if sysRes.pId?? && (sysRes.pId == (Request.viewId)!"") && sysRes.perms == "delete">
							{{# if(d.hasDefault=="N"){ }}
		          				<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
							{{# } }}
		          		</#if>
		          	</#list>
		        </script>
			</div>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/user/user_index.js"></script>
    <script>
		layui.config({
			base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
		}).extend({
			index: 'lib/index' //主入口模块
		}).use(['util','index', 'table'], callback);
    </script>
</@scripts>
</body>
</html>

