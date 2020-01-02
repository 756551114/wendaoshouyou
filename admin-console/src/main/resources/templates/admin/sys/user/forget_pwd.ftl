<#include "../../../layout.ftl" >
<@head title="忘记密码" >
    <style>
        #forget .layui-form-label{
            width: 85px;
            text-align: left;
        }
        .layui-input-inline-width{
            width: 305px!important;
        }
    </style>
</@head>
<body>
<div class="layui-form reg-body" style="padding: 20px 30px 0 0;" lay-filter="forget" id="forget">
    <div class="layui-form-item">
        <label class="layui-form-label">登录手机号：</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" id="tel" maxlength="11" lay-verify="required" lay-verType="tips" placeholder="" autocomplete="off" class="layui-input" value="">
        </div>
        <button class="layui-btn" lay-filter="getVerCode" id="getVerCode">获取验证码</button>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">验证码：</label>
        <div class="layui-input-inline layui-input-inline-width">
            <input type="text" name="code" id="code" maxlength="6" lay-verify="required" lay-verType="tips" placeholder="" autocomplete="off" class="layui-input" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">设置新密码：</label>
        <div class="layui-input-inline layui-input-inline-width">
            <input type="password" name="password" id="password" maxlength="10" lay-verify="required|pwd" lay-verType="tips" placeholder="" autocomplete="off" class="layui-input" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认新密码：</label>
        <div class="layui-input-inline layui-input-inline-width">
            <input type="password" name="repassword" id="repassword" maxlength="10" lay-verify="required|pwd" lay-verType="tips" placeholder="" autocomplete="off" class="layui-input" value="">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-hide" lay-submit lay-filter="forget-submit" id="forget-submit">提交</button>
    </div>
</div>
<@scripts>
	<script src="${application.getContextPath()}/js/admin/sys/user/forget_pwd.js"></script>
	<script>
        layui.config({
            base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
        }).extend({
            index: 'lib/index', //主入口模块
        }).use(['index', 'form'],callback);
    </script>
</@scripts>
</body>
</html>