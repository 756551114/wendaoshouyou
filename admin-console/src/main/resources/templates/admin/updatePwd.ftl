<#include "../layout.ftl" >
<@head title="修改密码" />
<body>
	<div class="layui-fluid">   
		 <div class="layui-row layui-col-space15">
	      <div class="layui-col-md12">
	        <div class="layui-card">
	          <div class="layui-card-header">修改密码</div>
	          <div class="layui-card-body" pad15>
	            
	            <div class="layui-form" lay-filter="">
	              <div class="layui-form-item">
	                <label class="layui-form-label">当前密码</label>
	                <div class="layui-input-inline">
	                  <input type="password" name="oldPassword" lay-verify="required" lay-verType="tips" class="layui-input">
	                </div>
	              </div>
	              <div class="layui-form-item">
	                <label class="layui-form-label">新密码</label>
	                <div class="layui-input-inline">
	                  <input type="password" name="password" id="password" lay-verify="required|passwd" lay-verType="tips" autocomplete="off" id="LAY_password" class="layui-input">
	                </div>
	              </div>
	              <div class="layui-form-item">
	                <label class="layui-form-label">确认新密码</label>
	                <div class="layui-input-inline">
	                  <input type="password" name="repassword" lay-verify="repassword" lay-verType="tips" autocomplete="off" class="layui-input">
	                </div>
	              </div>
	              <div class="layui-form-item">
	                <div class="layui-input-block">
	                  <button class="layui-btn" lay-submit lay-filter="setmypass">确认修改</button>
	                </div>
	              </div>
	            </div>
	            
	          </div>
	        </div>
	      </div>
	    </div>

	</div>

<@scripts>
	<script src="${application.getContextPath()}/js/admin/updatePwd.js"></script>
	<script>
		layui.config({
			base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
		}).extend({
			index: 'lib/index' //主入口模块
		}).use(['index','form'], callback);
	</script>
</@scripts>
</body>
</html>

