<#macro head title>
    <!DOCTYPE html>
    <html style="height: 100%;">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <link rel="stylesheet" href="${application.getContextPath()}/plugins/layui/css/layui.css" media="all">
        <link rel="stylesheet" href="${application.getContextPath()}/plugins/layui/css/admin.css" media="all">
        <link rel="stylesheet" href="${application.getContextPath()}/plugins/awesome/css/font-awesome.css">
        <link rel="icon" href="${application.getContextPath()}/yjy.ico" type="image/x-icon"/>
        <link rel="shortcut icon" href="${application.getContextPath()}/yjy.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="${application.getContextPath()}/plugins/layui/cropper/js/cropper/cropper.min.css"/>
        <link rel="stylesheet" type="text/css" href="${application.getContextPath()}/plugins/layui/cropper/css/style.css"/>
        <link rel="stylesheet" href="${application.getContextPath()}/plugins/layui/css/selects-v4/formSelects-v4.css">
         <link rel="stylesheet" type="text/css" href="${application.getContextPath()}/plugins/layui/css/inputFocusColor.css"/>
        <#nested />
    </head>
</#macro>

<#macro scripts>
    <script src="${application.getContextPath()}/plugins/layui/cropper/js/jquery/jquery.min.js"></script>
    <script src="${application.getContextPath()}/plugins/layui/cropper/js/cropper/cropper.min.js"></script>
    <script src="${application.getContextPath()}/plugins/layui/cropper/index.js"></script>

    <script>
        var _contextPath = '${application.getContextPath()}/';
        var _date_format = 'yyyy-MM-dd HH:mm:ss';
    </script>
    <script src="${application.getContextPath()}/plugins/layui/layui.js"></script>
    <script>
        layui.define(['jquery'], function (exports) {
            var $ = layui.jquery;
            $(document).ajaxComplete(function (event, request, settings) {
                if (request.getResponseHeader) {
                    var sessionStatus = request.getResponseHeader("sessionstatus");
                    if (sessionStatus == 'timeout') {
                        window.location.href = _contextPath + "login";
                        return;
                    }
                }
                layer.close(layer.load(1, {shade: [0.5, '#fff']}));
            });
            $(document).ajaxSend(function (event, request, settings) {
                layer.load(1, {shade: [0.5, '#fff']});
            });
            
        });
        layui.define(['table'],function(exports){
		    var options={
		        response: {
		            statusName: 'code' //规定数据状态的字段名称，默认：code
		            ,statusCode: 200 //规定成功的状态码，默认：0
		            ,msgName: 'msg' //规定状态信息的字段名称，默认：msg
		            ,countName: 'count' //规定数据总数的字段名称，默认：count
		            ,dataName: 'data' //规定数据列表的字段名称，默认：data
		        }
		    };
		    layui.table.set(options); //设定全局默认参数。options即各项基础参数
		});
        function refreshTab(u) {
            var $ = layui.jquery;
            $('#LAY_app_body>div',parent.document).each(function (e) {
                var url = $(this).children("iframe").attr("src");
                if(url==u){
                    $(this).children("iframe").attr("src",url);
                }
            });
        }
        //转化正整数
		function InputNumber(value){
		    value = value.replace(/[^\d]/g,'');
		    if(''!=value){
		        value = parseInt(value);
		    }
		    return value;
		}
    </script>
<#--    <script src="${application.getContextPath()}/plugins/layui/cropper/js/jquery/jquery.min.js"></script>-->
<#--    <script src="${application.getContextPath()}/plugins/layui/cropper/js/cropper/cropper.min.js"></script>-->
<#--    <script src="${application.getContextPath()}/plugins/layui/cropper/index.js"></script>-->
    <#nested />
</#macro>