 function callback(){
    var $ = layui.$;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    
    table.render({
		elem: "#tbl_sys_job",
		url: _contextPath + "admin/sys/job/job_data_list",
		height: 'full-180',
		limit: 20,
		page: true,
		cols: [
			[{
				field: "jobId",
				title: "jobId",
				hide: true
			},{
				field: "jobName",
				title: "岗位名称"
			},{
				field: "createTime",
				title: "创建时间",
				width: 175,
				templet: function(data){
			        return util.toDateString(data.createTime,_date_format);
			      }
			},{
				title: "操作",
				width: 250,
				align: "center",
				fixed: "right",
				toolbar: "#sys_job_toolbar"
			}]
		],
		text: {
			none: '暂无数据!'
		},
		request: {
			limitName: 'pageSize'
		  }
	}), table.on("tool(tbl_sys_job)", function(e) {
		e.data;
		if ("del" === e.event) layer.confirm("确定删除此岗位？", function(_$) {
			$.ajax({ url: _contextPath + "admin/sys/job/job_del?jobId=" +e.data.jobId, success: function(result){
				if(result.code == 200){
					layer.msg('操作成功!', {icon: 6});
					table.reload("tbl_sys_job");
				}else{
					layer.msg(result.msg, {icon: 5});
				}

		    }});
			layer.close(_$);
		});
		else if ("edit" === e.event) {
			$(e.tr);
			layer.open({
				type: 2,
				title: "编辑岗位",
				content: _contextPath + "admin/sys/job/job_edit?jobId=" +e.data.jobId,
				area: ["600px", "600px"],
				btn: ["确定", "取消"],
				yes: function(index, _dom) {
					var iframe = window["layui-layer-iframe" + index];
					var _submit = _dom.find("iframe").contents().find("#edit-sysJob-submit");
					iframe.layui.form.on("submit(edit-sysJob-submit)", function(_dom) {
						var _is_auth_empty = true;
		            	  for(var _key in _dom.field){
		            		  if(_key.indexOf('authids') != -1){
		            			  _is_auth_empty = false;
		            			  break;
		            		  }
		                  }
		            	  if(_is_auth_empty){
		            		  layer.msg('请选择权限!',{icon: 0});
		            		  return;
		            	  }
						$.ajax({ url: _contextPath + "admin/sys/job/job_edit",type: 'POST', data: _dom.field, success: function(result){
							if(result.code == 200){
								layer.msg('操作成功!', {icon: 6});
								table.reload("tbl_sys_job");
								layer.close(index);
							}else{
								layer.msg(result.msg, {icon: 5});
							}
					    }});
					});
					_submit.trigger("click");
				},
				success: function(index, _dom) {}
			})
		}
        else if("view" === e.event){
            $(e.tr);
            layer.open({
                type: 2,
                title: "查看岗位",
                content: _contextPath + "admin/sys/job/job_view?jobId=" +e.data.jobId,
                area: ["600px", "600px"],
                btn: ["关闭"],
                yes: function(index) {
                    layer.close(index);
                }
            })
        }
	});
  
    $('#add_job').on('click', function(){
    	layer.open({
    		type: 2
    		,title: '添加岗位'
    		,content: _contextPath + 'admin/sys/job/job_add'
            ,area: ['600px', '600px']
            ,btn: ['确定', '取消']
            ,yes: function(index, _dom){
              var iframe = window['layui-layer-iframe'+ index];
              var _submit = _dom.find('iframe').contents().find("#add-sysJob-submit");
              iframe.layui.form.on("submit(add-sysJob-submit)", function(_dom) {
            	  var _is_auth_empty = true;
            	  for(var _key in _dom.field){
            		  if(_key.indexOf('authids') != -1){
            			  _is_auth_empty = false;
            			  break;
            		  }
                  }
            	  if(_is_auth_empty){
            		  layer.msg('请选择权限!',{icon: 0});
            		  return;
            	  }
            	  $.ajax({ url: _contextPath + "admin/sys/job/job_add",type: 'POST', data: _dom.field, success: function(result){
            		  if(result.code == 200){
            			  layer.msg('操作成功!', {icon: 6});
						  table.reload("tbl_sys_job");
						  layer.close(index);
					  }else{
						  layer.msg(result.msg, {icon: 5});
					  }
				  }});
			  });
              _submit.trigger('click');
            }
          }); 
    });

}