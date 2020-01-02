 function callback(){
    var $ = layui.$;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    
    table.render({
		elem: "#tbl_sys_user",
		url: _contextPath + "admin/sys/user/user_data_list",
		height: 'full-180',
		limit: 20,
		page: true,
		cols: [
			[{
				field: "userId",
				title: "userId",
				hide: true
			},{
				field: "loginName",
				title: "登录名"
			},{
				field: "nickname",
				title: "姓名"
			},{
				field: "contactPhone",
				title: "手机号"
			},{
                field: "jobNames",
                title: "岗位"
            },{
				field: "sex",
				title: "性别",
				align: 'center',
				templet: function(data){
					if(data.sex == 0){
						return '女';
					}else{
						return '男';
					}
				}
			},{
				field: "email",
				title: "邮箱"
			},{
				field: "isEnabled",
				title: "是否启用",
				align: 'center',
				width: 100,
				templet: function(data){
					if(data.hasEnabled == 'N'){
						return '<button class="layui-btn layui-btn-disabled layui-btn-xs">已停用</button>';
					}else{
						return '<button class="layui-btn layui-btn-primary layui-btn-xs">使用中</button>';
					}
			    }
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
				toolbar: "#sys_user_toolbar"
			}]
		],
		text: {
			none: '暂无数据!'
		},
		request: {
			limitName: 'pageSize'
		  }
	});
     form.on('submit(search_sys_user)', function(data){
         table.reload('tbl_sys_user', {
             url: _contextPath + 'admin/sys/user/user_data_list',
             where: data.field,
             page: {
                 curr: 1 //重新从第 1 页开始
             }
         });
     });
    table.on("tool(tbl_sys_user)", function(e) {
		e.data;
		if ("del" === e.event) layer.confirm("确定删除此系统用户？", function(_$) {
			$.ajax({ url: _contextPath + "admin/sys/user/user_del?userId=" +e.data.userId, success: function(result){
				if(result.code == 200){
					layer.msg('操作成功!', {icon: 6});
					table.reload("tbl_sys_user");
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
                title: "编辑系统用户",
                content: _contextPath + "admin/sys/user/user_edit?userId=" +e.data.userId,
                area: ["600px", "600px"],
                btn: ["确定", "取消"],
                yes: function(index, _dom) {
                    var iframe = window["layui-layer-iframe" + index];
                    var _submit = _dom.find("iframe").contents().find("#add-sysUser-submit");
                    iframe.layui.form.on("submit(add-sysUser-submit)", function(_dom) {
                        $.ajax({ url: _contextPath + "admin/sys/user/user_edit",type: 'POST', data: _dom.field, success: function(result){
                                if(result.code == 200){
                                    layer.msg('操作成功!', {icon: 6});
                                    table.reload("tbl_sys_user");
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
                title: "查看系统用户",
                content: _contextPath + "admin/sys/user/user_view?userId=" +e.data.userId,
                area: ["600px", "600px"],
                btn: ["关闭"],
                yes: function(index) {
                    layer.close(index);
                }
            })
		}
	});
  
    $('#add_user').on('click', function(){
    	layer.open({
    		type: 2
    		,title: '添加系统用户' 
    		,content: _contextPath + 'admin/sys/user/user_add'
            ,area: ['600px', '600px']
            ,btn: ['确定', '取消']
            ,yes: function(index, _dom){
              var iframeWindow = window['layui-layer-iframe'+ index];
              var _submit = _dom.find('iframe').contents().find("#add-sysUser-submit");

              //监听提交
              iframeWindow.layui.form.on('submit(add-sysUser-submit)', function(_dom){
            	  $.ajax({ url: _contextPath + "admin/sys/user/user_add",type: 'POST', data: _dom.field, success: function(result){
						if(result.code == 200){
							layer.msg('操作成功!', {icon: 6});
							table.reload("tbl_sys_user");
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