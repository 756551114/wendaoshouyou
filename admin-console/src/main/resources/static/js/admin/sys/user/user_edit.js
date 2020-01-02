 function callback(){
	var $ = layui.$;
    var form = layui.form;
    var formSelects = layui.formSelects;

    form.verify({
    	jobIds: function(value, item){ //value：表单的值、item：表单的DOM对象
    		if(value == ''){
    			return '请先选择岗位!';
    		}
    	}
    });
    
 }