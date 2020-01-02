 function callback(){
	var $ = layui.$;
    var authtree = layui.authtree;
    
    // 初始化
	$.ajax({
		url: _contextPath + "admin/sys/job/job_2_res?disabled=true&jobId=" + $('#jobId').val(),
		dataType: 'json',
		success: function(result){
			// 渲染时传入渲染目标ID，树形结构数据（具体结构看样例，checked表示默认选中），以及input表单的名字
			authtree.render('#select_res', result.data.nodeList, {inputname: 'authids[]', layfilter: 'lay-check-auth', openall: true});
		}
	});
 }