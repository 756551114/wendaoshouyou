<#include "../../layout.ftl" >
<@head title="添加" />
<style>

</style>
<body>
<div class="layui-fluid" style="margin-top: 0px;">
    <div class="layui-card">
        <div class="layui-card-body layui-form">
            <input type="hidden" name="id" id="id" value="${(blackList.id)!}">

            <div class="layui-form-item">
                <label class="layui-form-label">ip:</label>
                <div class="layui-input-block">
                    <input type="text" name="ip" id="ip" class="layui-input"
                            placeholder="ip" autocomplete="off"  value="${(blackList.ip)!}">
                </div>
            </div>

            <div class="layui-form-item" style="display: none">
                <button class="layui-btn layui-hide" lay-submit lay-filter="submit" id="submit">提交
                </button>
            </div>
        </div>
    </div>

    <@scripts>
        <script>

        </script>
        <script src="${application.getContextPath()}/js/business/blackList/blackList_add.js"></script>
        <script>
            layui.config({
                base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
            }).extend({
                index: 'lib/index' //主入口模块
            }).use(['util', 'index', 'table', 'upload'], callback);
        </script>
    </@scripts>
</body>
</html>

