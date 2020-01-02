<#include "layout.ftl" >
<@head title="GM管理平台" >
<link rel="stylesheet" href="${application.getContextPath()}/plugins/layui/css/login.css" media="all">
<style>
  .layadmin-user-login-body{
    position:relative;
  }

  .layadmin-user-login{
      padding: 0;
      /*background-image: url("../static/img/welcome.png");*/
      background-image: url("http://image.gyyxcdn.cn/upload/edit/wd/imbanner/xf/2020_sydt.jpg");
      background-size: 100% 100%;
  }

  .title-img{
      /*width:80px;*/
      height:60px;
  }

  .custom-login-main{
      position: absolute;
      width:95%;
      height: 90%;
      top:50%;
      margin-top:-300px;
      left:50%;
      margin-left:-700px;
  }

  .layadmin-user-login-title{
      margin-left:120px;
      width:480px;
  }

  .layadmin-user-login-main{
      margin-top: 125px;
      margin-left:168px;
      width:440px;
      background-color:rgba(190,87,50,0.7);
      font-size: 15px;
  }

  .clearFloat{
      margin: 0 auto;
      width: 40%;
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
      background-color: #FF9248;
      border-radius: 4px;
  }

  .link-word{
      color: white !important;
      margin-top: 8px;
  }

  .layui-unselect span{
      color: #c8a970 !important;
  }

  .layui-form-checked[lay-skin=primary] i {
      border-color: #FF9248;
      background-color: #FF9248;
      color: white;
  }
  .title-word{
      font-size: 50px;
      color: black;
  }

  .welcome-div{
      margin-top: 250px;
      padding: 15px 0px 15px 20px;
      color: white !important;
      border-left: solid 5px white;
      font-family: PingFangSC-Semibold;
  }

  .welcome-title{
      color: black;
      font-weight: lighter;
      font-size: 50px;
      letter-spacing:4px;
  }
  .welcome-eng-title{
      color: black;
      font-weight: lighter;
      margin-top: 10px;
      font-size: 40px;
  }
  .welcome-login{
      display: block;
      height: 40px;
      line-height: 40px;
  }

  .button-row{
      margin-top:30px;
      /*margin-left: 130px;*/
  }
  .remember-pwd{
      position: absolute;
      top: 8px;
      left: 25px;
      color: white;
  }
  .remember-pwd-input{
      color: white;
  }
</style>
</@head>
<body>

  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="custom-login-main">
        <div class="layui-col-md6 welcome-div">
            <h1 class="welcome-title">为您的XXXXXX插上智慧的翅膀</h1>
            <h2 class="welcome-eng-title">Add the smart wings into your spots</h2>
        </div>
      <div class="layui-col-md6">
          <div class="layadmin-user-login-title layadmin-user-login-box layadmin-user-login-header">
              <div class="layui-col-md3">
<#--                  <img class="title-img" src="${application.getContextPath()}/static/img/title-bg1.png"/>-->
                  <img class="title-img" src="http://s.gyyx.cn/publictop/images/toplogo_201612.jpg"/>
              </div>
              <div class="layui-col-md9">
                  <h2 class="title-word">GM管理平台</h2>
              </div>
          </div>
        <div class="layadmin-user-login-main">
          <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
              <div class="layui-form-item welcome-login">
                  <label class="layadmin-user-login-icon" style="width: 90px;font-size: 20px;" for="LAY-user-login-username">欢迎登录</label>
              </div>
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
                <input class="remember-pwd-input" type="checkbox" name="remember-me" lay-skin="primary" title=""><label class="remember-pwd">记住密码</label>
                <a href="" class="link-word layadmin-user-jump-change layadmin-link" id="forgetPassword" style="margin-top: 8px;">忘记密码</a>
            </div>
              <div class="layui-form-item layui-row layui-col-space10 button-row">
                  <div  class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                      <button class="loginBtn layui-btn loginPageBtn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 录</button>
                  </div>
                  <div  class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                      <a class="loginPageBtn layui-btn layui-btn-fluid" href="" id="register" class="layadmin-user-jump-change layadmin-link">注 册</a>
                  </div>
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
  var passKey = '046cb2ec4c724a388d6dba66d884342d';
  layui.config({
    base: '${application.getContextPath()}/plugins/layui/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user'], function(){
    var $ = layui.$
    ,form = layui.form

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
	                  window.location.href = '${application.getContextPath()}/admin/index'; //后台主页
	                });	
	        	}else{
	        		layer.msg(res.msg);
	        	}
            }
        });
    });
      //点击验证码
      $('#verifyDiv').on('click',function(event){
          $("#verifyDiv img").attr("src",$("#verifyDiv img").attr("src")+"?"+Math.random());
      });
    //注册
    $('#register').on('click',function(event){
        event.preventDefault();
      layer.open({
        type: 2,
        title:'注册',
        content:_contextPath + 'admin/sys/user/register',
        closeBtn:0,
        area: ["500px", "300px"],
        btn: ["提交", "取消"],
        yes: function(index, _dom) {
            var iframe = window["layui-layer-iframe" + index];
            var _submit = _dom.find("iframe").contents().find("#register-submit");
            iframe.layui.form.on("submit(register-submit)", function(_dom) {
                $.ajax({ url: _contextPath + "admin/sys/user/registerPost",type: 'POST', data: _dom.field, success: function(result){
                    if(result.code == 200){
                        layer.msg("注册成功!", {icon: 6,time:1000},function(){
                            //请求登入接口
                            $.ajax({
                                url:'${application.getContextPath()}/login',
                                method:'post',
                                data:{"username":_dom.field.tel,"password":_dom.field.password,"verifyCode":"123206b218ad4e6eac0e3030d27d18ff"},
                                success:function(res){
                                    if(res.sta == 200){
                                        window.location.href = '${application.getContextPath()}/admin/index?defOpenType=1'; //后台主页
                                    }else{
                                        layer.msg(res.msg);
                                    }
                                }
                            });
                        });
                    }else{
                        layer.msg(result.msg, {icon: 5});
                    }
                }});
            });
            _submit.trigger("click");
        }
      })
    });

      //忘记密码
      $('#forgetPassword').on('click',function(event){
          event.preventDefault();
          layer.open({
              type: 2,
              title:'忘记密码',
              content:_contextPath + 'admin/sys/user/forget_pwd',
              closeBtn:0,
              area: ["500px", "350px"],
              btn: ["提交", "取消"],
              yes: function(index, _dom) {
                  var iframe = window["layui-layer-iframe" + index];
                  var _submit = _dom.find("iframe").contents().find("#forget-submit");
                  iframe.layui.form.on("submit(forget-submit)", function(_dom) {
                      $.ajax({ url: _contextPath + "admin/sys/user/forgetPwd",type: 'POST', data: _dom.field, success: function(result){
                              if(result.code == 200){
                                  layer.msg("重置密码成功!", {icon: 6});
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