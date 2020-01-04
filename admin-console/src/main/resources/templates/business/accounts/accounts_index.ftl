<#include "../../layout.ftl" >
<@head title="管理" >

</@head>
<body>
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-body">
            <div class="layui-form-item">
                <div class="layui-inline">
                    账号:
                </div>
                <div class="layui-inline">
                    <input type="text" name="name" id="name" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-inline">
                    <button class="layui-btn" id="search">
                        查询
                    </button>
                </div>
            </div>
            <table id="my_table" class="layui-table" lay-filter="my_table">


            </table>
        </div>
    </div>


</div>
<@scripts>
    <script src="${application.getContextPath()}/js/business/accounts/accounts_index.js"></script>
    <script>
        layui.config({
            base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'form', 'authtree', 'element', 'table'], callback);
    </script>
</@scripts>
</body>
</html>