<#include "layout.ftl" >
<@head title="GM管理平台" >
    <link rel="stylesheet" href="${application.getContextPath()}/plugins/layui/css/login.css" media="all">
    <style>
        .layadmin-user-login-body{
            position:relative;
        }

        .layadmin-user-login{
            padding: 0;
        }

        .login-img{
            width:500px;
            height:600px;
        }

        .title-img{
            /*width:150px;*/
            height:50px;
        }

        .custom-login-main{
            position: absolute;
            width:1220px;
            height: 600px;
            background: #ffffff;
            top:50%;
            margin-top:-300px;
            left:50%;
            margin-left:-610px;
            box-shadow: 0px 5px 20px 0px #e7e7e7;
            border-radius: 10px;
            border: solid 1px #e7e7e7;
        }

        .layadmin-user-login-main{
            margin-left:160px;
            width:440px;
        }

        .otherinfo{
            position:absolute;
            bottom: 15px;
            right: -60px;
        }

        .loginPageBtn{
            display: block;
            line-height: 38px;
            font-family: PingFangSC-Semibold;
            font-size: 18px;
            letter-spacing: 0px;
            color: #ffffff;
            height:38px;
            text-align: center;
            background-image: linear-gradient(90deg,
            #e6d4a9 0%,
            #c8a970 100%);
            border-radius: 4px;
        }

        .link-word{
            color: #c8a970 !important;
        }

        .layui-unselect span{
            color: #c8a970 !important;
        }

        .layui-form-checked[lay-skin=primary] i {
            border-color: #c8a970;
            background-color: #c8a970;
            color: #fff;
        }
        .title-word{
            margin-top: 10px;
            color: #1e3a6a !important;
            font-weight: bold;
            font-family: PingFangSC-Semibold;
        }

        .button-row{
            margin-top:50px;
        }
    </style>
</@head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="custom-login-main">
        <div class="layui-inline">
            <img class="login-img" src="${application.getContextPath()}/img/login-bg.png"/>
        </div>
        <div class="layui-inline">
            <div class="layadmin-user-login-main">
                <div class="layadmin-user-login-box layadmin-user-login-header">
                    <img class="title-img" src="${application.getContextPath()}/img/title-bg.png"/>
                    <h2 class="title-word">GM管理平台</h2>
                </div>
                <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                        <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                        <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-row">
                            <div class="layui-col-xs8">
                                <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                                <input type="text" name="verifyCode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                            </div>
                            <div class="layui-col-xs4">
                                <div style="margin-left: 10px;" id="verifyDiv">
                                    <img src="${application.getContextPath()}/verifyCode" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item" style="margin-bottom: 20px;">
                        <input type="checkbox" name="remember-me" lay-skin="primary" title="记住密码">
<#--                        <a href="forget" class="link-word layadmin-user-jump-change layadmin-link" id="forgetPassword" style="margin-top: 8px;">忘记密码</a>-->
                    </div>
                    <div class="layui-form-item layui-row layui-col-space10 button-row">
                        <div  class="layui-col-xs6 layui-col-sm6 layui-col-md12">
                            <button class="loginBtn layui-btn loginPageBtn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 录</button>
                        </div>
<#--                        <div  class="layui-col-xs6 layui-col-sm6 layui-col-md6">-->
<#--                            <a class="loginPageBtn layui-btn layui-btn-fluid" href="register_index" class="layadmin-user-jump-change layadmin-link">注 册</a>-->
<#--                        </div>-->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">
        <p></p>
    </div>


</div>
<@scripts>
    <script src="${application.getContextPath()}/js/admin/simpleEncrypt.js"></script>
    <script>
        var verifyCodeUrl = '${application.getContextPath()}/verifyCode';
        var passKey = '046cb2ec4c724a388d6dba66d884342d';
        layui.config({
            base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'user'], function(){
            var $ = layui.$
                ,setter = layui.setter
                ,admin = layui.admin
                ,form = layui.form
                ,router = layui.router()
                ,search = router.search;

            form.render();

            $(document).keyup(function(event){
                if(event.keyCode ==13){
                    $('.loginBtn').trigger('click');
                }
            });



            var cookie = {
                set:function(key,val,time){//设置cookie方法
                    var date=new Date(); //获取当前时间
                    var expiresDays=time;  //将date设置为n天以后的时间
                    date.setTime(date.getTime()+expiresDays*24*3600*1000); //格式化为cookie识别的时间
                    document.cookie=key + "=" + val +";expires="+date.toGMTString();  //设置cookie
                },
                get:function(key) {//获取cookie方法
                    /*获取cookie参数*/
                    var getCookie = document.cookie.replace(/[ ]/g, "");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
                    var arrCookie = getCookie.split(";")  //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
                    var tips;  //声明变量tips
                    for (var i = 0; i < arrCookie.length; i++) {   //使用for循环查找cookie中的tips变量
                        var arr = arrCookie[i].split("=");   //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
                        if (key == arr[0]) {  //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                            tips = arr[1];   //将cookie的值赋给变量tips
                            break;   //终止for循环遍历
                        }
                    }
                    return tips;
                },
                delete:function(key){ //删除cookie方法
                    var date = new Date(); //获取当前时间
                    date.setTime(date.getTime()-10000); //将date设置为过去的时间
                    document.cookie = key + "=v; expires =" +date.toGMTString();//设置cookie
                }
            }

            var username = cookie.get("username");
            var password = decrypt(decodeURIComponent(cookie.get("password")),passKey+username);
            var rememberMe = cookie.get("rememberMe");
            if(rememberMe){
                $('input[name="username"]').val(username);
                $('input[name="password"]').val(password);
                $('input[name="remember-me"]').attr('checked', true);
                form.render();
            }

            //提交
            form.on('submit(LAY-user-login-submit)', function(data){
                //请求登入接口
                $.ajax({
                    url:'${application.getContextPath()}/login',
                    method:'post',
                    data:data.field,
                    success:function(res){
                        if(res.sta == 200){
                            if($('input[name="remember-me"]').prop('checked')) {
                                var userName = $('input[name="username"]').val();
                                cookie.set("username",userName , 7);
                                cookie.set("password", encrypt(encodeURIComponent($('input[name="password"]').val()),passKey+userName), 7);
                                cookie.set("rememberMe", true, 7);
                            }
                            else{
                                cookie.delete("username");
                                cookie.delete("password");
                                cookie.delete("rememberMe");
                            }

                            //登入成功的提示与跳转
                            layer.msg('登录成功', {
                                offset: '15px'
                                ,icon: 1
                                ,time: 200
                            }, function(){
                                location.href = '${application.getContextPath()}/admin/index'; //后台主页
                            });
                        }else{
                            layer.msg(res.msg);
                        }
                    }
                });
            });

            var forgetStr = ` <div class="layui-form reg-body" style="padding: 20px 30px 0 0;" lay-filter="forget" id="forget">
        <div class="layui-form-item">
          <label class="layui-form-label">商户编号：</label>
          <div class="layui-input-block">
            <input type="text" name="mrchId" id="mrchId" lay-verify="required" lay-verType="tips" placeholder="" autocomplete="off" class="layui-input" value="">
          </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商户名称：</label>
            <div class="layui-input-block">
              <input type="text" name="mrchName" id="mrchName" lay-verify="required" lay-verType="tips" placeholder="" autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item" style="text-align:center;color:red">
            <span>您的密码将以短信形式发送至商户联系人手机。</span>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn layui-hide" lay-submit lay-filter="forget-submit" id="forget-submit">提交</button>
        </div>
    </div>`;
            //点击验证码
            $('#verifyDiv').on('click',function(event){
                $("#verifyDiv img").attr("src",$("#verifyDiv img").attr("src")+"?"+Math.random());
            });
            //忘记密码
            $('#forgetPassword').on('click',function(event){
                event.preventDefault();
                layer.open({
                    type: 1,
                    title:'忘记密码',
                    content:forgetStr,
                    closeBtn:0,
                    area: ["420px", "260px"],
                    btn: ["提交", "取消"],
                    yes: function(index, _dom) {
                        var _submit = _dom.contents().find("#forget-submit");
                        form.on("submit(forget-submit)", function(_dom) {
                            $.ajax({ url: _contextPath + "travel/merchant/forgetMerchantPwd",type: 'POST', data: _dom.field, success: function(result){
                                    if(result.code == 0){
                                        layer.msg(result.msg, {icon: 6});
                                        layer.close(index);
                                    }else{
                                        layer.msg(result.msg, {icon: 5});
                                    }
                                }});
                        });
                        _submit.trigger("click");
                    }
                })
            });

            <#if (Session.loginUser)??>
            location.href = '${application.getContextPath()}/admin/index'; //后台主页
            </#if>
            if (window != top){
                top.location.href = location.href;
            }
        });
    </script>
</@scripts>
</body>
</html>