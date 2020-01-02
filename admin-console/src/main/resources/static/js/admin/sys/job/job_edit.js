 function callback(){
	var $ = layui.$;
    var form = layui.form;
    var authtree = layui.authtree;

     form.verify({
         jobName: function (value,item) {
             if (value.length > 20) {
                 return '长度不符合规范,超过20位';
             }
         }
     });

    // 初始化
	$.ajax({
		url: _contextPath + "admin/sys/job/job_2_res?disabled=false&jobId=" + $('#jobId').val(),
		dataType: 'json',
		success: function(result){
			// 渲染时传入渲染目标ID，树形结构数据（具体结构看样例，checked表示默认选中），以及input表单的名字
			authtree.render('#select_res', result.data.nodeList, {inputname: 'authids[]', layfilter: 'lay-check-auth', openall: true});
		}
	});
 }