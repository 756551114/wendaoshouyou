<#include "../../../layout.ftl" >
<@head title="编辑系统用户" >
</@head>
<body>
	<div class="layui-form" lay-filter="layuiadmin-form-role" id="layuiadmin-form-role" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item">
			<label class="layui-form-label">登录名：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="userId" lay-verify="required" lay-verType="tips"
						autocomplete="off" class="layui-input layui-hide" value="${sysUser.userId}">
					<input type="text" name="loginName" lay-verify="required|loginName" lay-verType="tips" placeholder="请输入登录名"
						autocomplete="off" class="layui-input layui-disabled" value="${sysUser.loginName}" disabled>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">岗位：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<select name="jobIds" lay-verify="jobIds" lay-verType="tips" xm-select="jobSelect" xm-select-max="3">
						<#list jobList as job>
							<#if sysUser.ownerJobIdList??>
								<#assign selected="false"/>
								<#list sysUser.ownerJobIdList as jobId>
									<#if jobId == job.jobId>
										<#assign selected="true"/>
										<#break>
									</#if>
								</#list>
								<#if selected == 'true'>
									<option value="${job.jobId}" selected="selected">${job.jobName}</option>
								<#else>
									<option value="${job.jobId}">${job.jobName}</option>
								</#if>
							<#else>
								<option value="${job.jobId}">${job.jobName}</option>
							</#if>
					    </#list>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="nickname" placeholder="请输入姓名"
						autocomplete="off" lay-verify="nickname" lay-verType="tips" class="layui-input" value="${(sysUser.nickname)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="contactPhone" placeholder="请输入联系电话" 
						autocomplete="off" lay-verify="phone" lay-verType="tips" class="layui-input" value="${(sysUser.contactPhone)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别：</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" value="1" title="男" <#if sysUser.sex == 1>checked</#if>>
				<input type="radio" name="sex" value="0" title="女" <#if sysUser.sex == 0>checked</#if>>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="email" placeholder="请输入邮箱" 
						autocomplete="off" lay-verify="email" lay-verType="tips" class="layui-input" value="${(sysUser.email)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">是否启用：</label>
			<div class="layui-input-block">
				<input type="radio" name="hasEnabled" value="Y" title="启用"  <#if sysUser.hasEnabled == "Y">checked</#if>>
				<input type="radio" name="hasEnabled" value="N" title="禁用"   <#if sysUser.hasEnabled == "N">checked</#if>>
			</div>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-hide" lay-submit lay-filter="add-sysUser-submit" id="add-sysUser-submit">提交</button>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/user/user_add.js"></script>
	<script>
		layui.config({
			base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
		}).extend({
			index: 'lib/index', //主入口模块
			formSelects: 'formSelects-v4'
		}).use(['index', 'form','formSelects'], callback);
	</script>
</@scripts>
</body>
</html>