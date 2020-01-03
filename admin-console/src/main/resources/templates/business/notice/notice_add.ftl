<#include "../../layout.ftl" >
<@head title="添加" />
<style>

</style>
<body>
<div class="layui-fluid" style="margin-top: 0px;">
    <div class="layui-card">
        <div class="layui-card-body layui-form">
            <div class="layui-form-item">
                <input type="hidden" name="id" id="id" value="${(notice.id)!}">
                <label class="layui-form-label"><span class="required">*</span>轮询时间:</label>
                <div class="layui-input-block">
                    <input type="number" name="time" id="time" class="layui-input" min="1" max="999999"
                           required lay-verify="required" placeholder="请输入轮询时间" autocomplete="off"  value="${(notice.time)!}"
                    >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="required">*</span>内容:</label>
                <div class="layui-input-block">
                    <textarea name="message" id="message" maxlength="250" class="layui-textarea" autocomplete="off" required lay-verify="required">${(notice.message)!}</textarea>
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
        <script src="${application.getContextPath()}/js/business/notice/notice_add.js"></script>
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

