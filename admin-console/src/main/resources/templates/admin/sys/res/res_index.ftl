<#include "../../../layout.ftl" >
<@head title="资源管理" />
<body>
	<div class="layui-fluid">   
		<div class="layui-card">
			<div class="layui-form layui-card-header layuiadmin-card-header-auto">
				<div class="layui-form-item">
					<div class="layui-inline">
               			机构类型
          			</div>
					<div class="layui-inline">
			            <select name="orgType">
			              <option value="-1">全部资源</option>
							<option value="0">管理平台</option>
							<option value="1">运营商</option>
							<option value="2">分销商 </option>
							<option value="3">商户</option>
			            </select>
					</div>
					<div class="layui-inline">
						资源名称
					</div>
					<div class="layui-inline">
						<input type="text" name="resName" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-inline">
						<button class="layui-btn" lay-submit lay-filter="search_sys_resource">
							查询
						</button>
					</div>
				</div>
			</div>
			<div class="layui-card-body">
				<#list Session.loginUser.resList as sysRes>
					<#if sysRes.pId?? && (sysRes.pId == (Request.viewId)!"") && sysRes.perms == "add">
				        <div style="padding-bottom: 10px;text-align:right;">
							<button class="layui-btn" id="add_res">
								<i class="layui-icon">&#xe608;</i> 添加
							</button>
				        </div>
		        	</#if>
		        </#list>
		        <table id="tbl_sys_resource" lay-filter="tbl_sys_resource">
		        	
		        </table>  
		        <script type="text/html" id="sys_resource_toolbar">
		        	<#list Session.loginUser.resList as sysRes>
		        		<#if sysRes.pId?? && (sysRes.pId == (Request.viewId)!"") && sysRes.perms == "update">
		          			<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
		          		</#if>
		          		<#if sysRes.pId?? && (sysRes.pId == (Request.viewId)!"") && sysRes.perms == "delete">
		          			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
		          		</#if>
		          	</#list>
		        </script>
			</div>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/res/res_index.js"></script>
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

