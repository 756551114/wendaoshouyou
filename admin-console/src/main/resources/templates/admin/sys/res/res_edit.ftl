<#include "../../../layout.ftl" >
<@head title="编辑资源" >
<style>
.layui-anim-upbit{
	width:290px;
}
</style>
</@head>
<body>
	<div class="layui-form" lay-filter="layuiadmin-form-role" id="layuiadmin-form-role" style="padding: 20px 30px 0 0;">
		<div class="layui-form-item">
			<label class="layui-form-label">名称：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="resId" class="layui-hide" value="${sysRes.resId}">
					<input type="text" name="resName" lay-verify="required|resName" lay-verType="tips" placeholder="请输入名称"
						autocomplete="off" class="layui-input" value="${sysRes.resName}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">机构类型：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<select name="orgType" lay-filter="orgType" disabled>
						<option value="0" <#if sysRes.orgType == 0>selected</#if> >管理平台</option>
						<option value="1" <#if sysRes.orgType == 1>selected</#if> >运营商</option>
						<option value="2" <#if sysRes.orgType == 2>selected</#if> >分销商 </option>
						<option value="3" <#if sysRes.orgType == 3>selected</#if> >商户</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">父资源：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<select name="pName">
						<option value="0,无">无</option>
						<#if typeResList?? && typeResList?size &gt; 0>
							<#list typeResList as typeRes>
								<#if sysRes.resId != typeRes.resId>
									<option value="${typeRes.resId},${typeRes.resName}" <#if sysRes.pId?? && sysRes.pId == typeRes.resId>selected</#if>>${typeRes.resName}</option>
								</#if>
							</#list>
						</#if>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单类型：</label>
			<div class="layui-input-block">
				<input type="radio" name="resType" value="0" title="菜单" <#if sysRes.resType == 0>checked</#if> disabled>
				<input type="radio" name="resType" value="1" title="按钮" <#if sysRes.resType == 1>checked</#if> disabled>
			</div>
		</div>
		<#if sysRes.resType == 0>
			<div class="layui-form-item">
				<label class="layui-form-label">图标：</label>
				<div class="layui-input-block">
					<div class="layui-col-md12">
						<input type="text" name="resIcon" id="iconPicker" lay-filter="iconPicker" class="layui-input" value="${(sysRes.resIcon)!}">
					</div>
				</div>
			</div>
		<#else>
			<div class="layui-form-item">
				<label class="layui-form-label">权限：</label>
				<div class="layui-input-block">
					<input type="radio" name="perms" value="add" title="新增" <#if sysRes.perms?? && sysRes.perms = 'add'>checked</#if>>
					<input type="radio" name="perms" value="delete" title="删除" <#if sysRes.perms?? && sysRes.perms = 'delete'>checked</#if>>
					<input type="radio" name="perms" value="view" title="查看" <#if sysRes.perms?? && sysRes.perms = 'view'>checked</#if>>
					<input type="radio" name="perms" value="update" title="修改" <#if sysRes.perms?? && sysRes.perms = 'update'>checked</#if>>
				</div>
			</div>
		</#if>
		<div class="layui-form-item">
			<label class="layui-form-label">URL：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="resUrl" lay-verify="resUrl" lay-verType="tips" placeholder="请输入URL" autocomplete="off" class="layui-input" value="${(sysRes.resUrl)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源顺序：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="orderNum" lay-verify="number" lay-verType="tips" placeholder="请输入资源顺序" 
						autocomplete="off" class="layui-input" value="${(sysRes.orderNum)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-hide" lay-submit lay-filter="edit-sysRes-submit" id="edit-sysRes-submit">提交</button>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/res/res_edit.js"></script>
	<script>
		layui.config({
			base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
		}).extend({
			index: 'lib/index' //主入口模块
		}).use(['index', 'form','iconPicker'], callback);
	</script>
</@scripts>
</body>
</html>