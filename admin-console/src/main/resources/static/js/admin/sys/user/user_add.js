 function callback(){
	var $ = layui.$;
    var form = layui.form;

    form.verify({
    	jobIds: function(value, item){ //value：表单的值、item：表单的DOM对象
    		if(value == ''){
    			return '请先选择岗位!';
    		}
    	},
        loginName: function (value,item) {
            if(!new RegExp("^[a-zA-Z0-9\\s·]+$").test(value)){
                return '不能有特殊字符及中文';
            }
            if (value.length > 20) {
                return '长度不符合规范,超过20位';
            }
        },
        nickname: function (value,item) {
            if (value.length > 20) {
                return '长度不符合规范,超过20位';
            }
        }
    });
    
 }