<#include "../../../layout.ftl" >
<@head title="编辑岗位" >

</@head>
<body>
	<div class="layui-form" lay-filter="layuiadmin-form-role" id="layuiadmin-form-role" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item">
			<label class="layui-form-label">名称：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" id="jobId" name="jobId" lay-verify="required" lay-verType="tips" placeholder="请输入名称"
						autocomplete="off" class="layui-input layui-hide" value="${sysJob.jobId}">
					<input type="text" name="jobName" lay-verify="required" lay-verType="tips" placeholder="请输入名称"
						autocomplete="off" class="layui-input layui-disabled" value="${sysJob.jobName}" disabled>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">选择权限：</label>
			<div class="layui-input-block">
				<div id="select_res" lay-filter="select_res" class="layui-disabled"></div>
			</div>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/job/job_view.js"></script>
	<script>
		layui.config({
			base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
		}).extend({
			index: 'lib/index' //主入口模块
		}).use(['index','authtree'], callback);
	</script>
</@scripts>
</body>
</html>