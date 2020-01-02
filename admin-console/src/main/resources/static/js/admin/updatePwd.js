 function callback(){
    var $ = layui.$;
    var form = layui.form;
    
    form.verify({
        passwd:function(value, item){
            if(new RegExp("^[\u4E00-\u9FA5]+$").test(value)){
				 return '不能有中文';
			 }
            if (value.length > 20) {
                return '长度不符合规范,超过20位';
            }
            if (value.length < 6) {
                return '长度不符合规范,不足6位';
            }
		},
    	repassword: function(value, item){ //value：表单的值、item：表单的DOM对象
		    if($('#password').val() != value){
		      return '两次输入密码不一致，请检查!';
		    }
		}
	});  
    
    form.on('submit(setmypass)', function(data){
    	$.ajax({ url: _contextPath + "admin/updatePwd",type: 'POST', data: data.field, success: function(result){
			if(result.code == 200){
				layer.msg('操作成功!', {icon: 6});
				top.location.href = _contextPath+'logout';
			}else{
				layer.msg(result.msg, {icon: 5});
			}
	    }});
	});

}