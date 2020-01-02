<#include "../../../layout.ftl" >
<@head title="新增岗位" >

</@head>
<body>
	<div class="layui-form" lay-filter="layuiadmin-form-role" id="layuiadmin-form-role" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item">
			<label class="layui-form-label">名称：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="jobName" lay-verify="required|jobName" lay-verType="tips" placeholder="请输入名称"
						autocomplete="off" class="layui-input" value="">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">选择权限：</label>
			<div class="layui-input-block">
				<div id="select_res" lay-filter="select_res"></div>
			</div>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-hide" lay-submit lay-filter="add-sysJob-submit" id="add-sysJob-submit">提交</button>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/job/job_add.js"></script>
	<script>
		layui.config({
			base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
		}).extend({
			index: 'lib/index' //主入口模块
		}).use(['index','form','authtree'], callback);
	</script>
</@scripts>
</body>
</html>