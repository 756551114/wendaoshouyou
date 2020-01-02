var flag = true;
function callback(){
    var $ = layui.jquery;
    var form = layui.form;
    form.verify({
        pwd: function (value,item) {
            if(!(/^(?=.*?[a-z)(?=.*>[A-Z])(?=.*?[0-9])[a-zA_Z0-9]{6,10}$/).test(value)){
                return '密码必须包含数字和字母，长度在6-10之间';
            }
        }
    });

    $("#getVerCode").on("click",function () {
        var mobile = $("#tel").val();
        if(mobile && mobile.length == 11){
            if(/^1\d{10}$/.test(mobile)){
                if(!flag){
                    return;
                }
                flag = false;
                $.ajax({
                    url:_contextPath+'admin/sys/common/sendSms',
                    data:{"tel":$("#tel").val(),"type":2},
                    type: 'POST',
                    success:function(res){
                        if(res.code == 200){
                            layer.msg("发送成功");
                            var time = 60;
                            var timeStop = setInterval(function(){
                                time--;
                                if (time>0) {
                                    $("#getVerCode").text("重发(" + time +"s)");
                                    $("#getVerCode").addClass("layui-btn-disabled");
                                    $("#getVerCode").attr("disabled","disabled");//禁止点击
                                }else{
                                    flag = true;
                                    time = 60;//当减到0时赋值为60
                                    $("#getVerCode").text("获取验证码");
                                    clearInterval(timeStop);//清除定时器
                                    $("#getVerCode").removeClass("layui-btn-disabled");
                                    $("#getVerCode").removeAttr("disabled");//移除属性，可点击
                                }
                            },1000)
                        }else{
                            flag = true;
                            layer.msg(res.msg);
                        }
                    }
                });
            }else{
                layer.msg("请输入正确的手机号");
            }
        }else{
            layer.msg("请输入正确的手机号");
        }
    });
}