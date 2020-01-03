<#include "../../../layout.ftl" >
<@head title="新增资源" >
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
					<input type="text" name="resName" lay-verify="required|resName" lay-verType="tips" placeholder="请输入名称"
						autocomplete="off" class="layui-input" value="">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">机构类型：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<select name="orgType" lay-filter="orgType">
						<option value="0">管理平台</option>
<#--						<option value="1">运营商</option>-->
<#--						<option value="2">分销商 </option>-->
<#--						<option value="3">商户</option>-->
<#--						<option value="100">待审核商户</option>-->
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">父资源：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<select name="pName" id="parentName">
						<option value="0,无">无</option>
						<#if typeResList?? && typeResList?size &gt; 0>
							<#list typeResList as typeRes>
								<option value="${typeRes.resId},${typeRes.resName}">${typeRes.resName}</option>
							</#list>
						</#if>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单类型：</label>
			<div class="layui-input-block">
				<input type="radio" name="resType" lay-filter="resType" value="0" title="菜单" checked>
				<#--<input type="radio" name="resType" lay-filter="resType" value="1" title="按钮">-->
			</div>
		</div>
		<div class="layui-form-item" id="iconDiv">
			<label class="layui-form-label">图标：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="resIcon" id="iconPicker" lay-filter="iconPicker" class="layui-input" value="">
				</div>
			</div>
		</div>
			
		<div class="layui-form-item layui-hide" id="permsDiv">
			<label class="layui-form-label">权限：</label>
			<div class="layui-input-block">
				<input type="radio" name="perms" value="add" title="新增" checked>
				<input type="radio" name="perms" value="delete" title="删除">
				<input type="radio" name="perms" value="view" title="查看">
				<input type="radio" name="perms" value="update" title="修改">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">URL：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="resUrl" lay-verify="resUrl" lay-verType="tips" placeholder="请输入URL" autocomplete="off" class="layui-input" value="">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源顺序：</label>
			<div class="layui-input-block">
				<div class="layui-col-md12">
					<input type="text" name="orderNum" lay-verify="number" lay-verType="tips" placeholder="请输入资源顺序" 
						autocomplete="off" class="layui-input" value="">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-hide" lay-submit lay-filter="add-sysRes-submit" id="add-sysRes-submit">提交</button>
		</div>
	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/res/res_add.js"></script>
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