 function callback(){
    var $ = layui.$;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    
    table.render({
		elem: "#tbl_sys_resource",
		url: _contextPath + "admin/sys/res/res_data_list",
		height: 'full-180',
		limit: 20,
		page: true,
		cols: [
			[{
				field: "resId",
				title: "resId",
				hide: true
			},{
				field: "resName",
				title: "名称"
			},{
				field: "resIcon",
				title: "图标",
				width: 60,
				align: 'center',
				templet: function(data){
					return '<i class="layui-icon ' + data.resIcon + '"></i>';
					}
			},{
				field: "resUrl",
				title: "地址",
				width: '30%'
			},{
				field: "perms",
				title: "权限",
				align: 'center'
			},{
				field: "pName",
				title: "父名称"
			},{
				field: "resType",
				title: "类型",
				align: 'center',
				templet: function(data){
					if(data.resType == 0){
						return '菜单';
					}else{
						return '按钮';
					}
				}
			},{
				field: "orderNum",
				title: "顺序",
				align: 'center'
			},{
				field: "createTime",
				title: "创建时间",
				width: 175,
				templet: function(data){
			        return util.toDateString(data.createTime,_date_format);
			      }
			},{
				title: "操作",
				width: 150,
				align: "center",
				fixed: "right",
				toolbar: "#sys_resource_toolbar"
			}]
		],
		text: {
			none: '暂无数据!'
		},
		request: {
			limitName: 'pageSize'
		  }
	}), table.on("tool(tbl_sys_resource)", function(e) {
		e.data;
		if ("del" === e.event) layer.confirm("确定删除此资源？", function(_$) {
			$.ajax({ url: _contextPath + "admin/sys/res/res_del?resId=" +e.data.resId, success: function(result){
				if(result.code == 200){
					layer.msg('操作成功!', {icon: 6});
					table.reload("tbl_sys_resource");
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
				title: "编辑资源",
				content: _contextPath + "admin/sys/res/res_edit?resId=" +e.data.resId,
				area: ["600px", "600px"],
				btn: ["确定", "取消"],
				yes: function(index, _dom) {
					var iframe = window["layui-layer-iframe" + index];
					var _submit = _dom.find("iframe").contents().find("#edit-sysRes-submit");
					iframe.layui.form.on("submit(edit-sysRes-submit)", function(_dom) {   
						$.ajax({ url: _contextPath + "admin/sys/res/res_edit",type: 'POST', data: _dom.field, success: function(result){
							if(result.code == 200){
								layer.msg('操作成功!', {icon: 6});
								table.reload("tbl_sys_resource");
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
	});
  
    $('#add_res').on('click', function(){
    	layer.open({
    		type: 2
    		,title: '添加资源'
    		,content: _contextPath + 'admin/sys/res/res_add'
            ,area: ['600px', '600px']
            ,btn: ['确定', '取消']
            ,yes: function(index, _dom){
              var iframeWindow = window['layui-layer-iframe'+ index];
              var _submit = _dom.find('iframe').contents().find("#add-sysRes-submit");

              //监听提交
              iframeWindow.layui.form.on('submit(add-sysRes-submit)', function(_dom){
            	  $.ajax({ url: _contextPath + "admin/sys/res/res_add",type: 'POST', data: _dom.field, success: function(result){
						if(result.code == 200){
							layer.msg('操作成功!', {icon: 6});
							table.reload("tbl_sys_resource");
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

     form.on('submit(search_sys_resource)', function(data){
         table.reload('tbl_sys_resource', {
             url: _contextPath + 'admin/sys/res/res_data_list',
             where: data.field,
             page: {
                 curr: 1 //重新从第 1 页开始
             }
         });
     });
}