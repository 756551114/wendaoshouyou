//未发布


function getParams($) {
    var data = {
        name: $('#name').val(),
    };
    return data;
}


function callback() {
    var $ = layui.$;
    var table = layui.table;



    table.render({
        elem: '#my_table'
        , height: 312
        , limit: 20
        , height: 'full-150'
        , url: _contextPath + 'business/accounts/accounts_data'
        , page: true //开启分页
        , cols: [[
            {
                field: "id",
                title: "id",
                hide: true
            }, {
                field: "name",
                title: "账号",
            }, {
                width: 90,
                field: "vip",
                title: "vip等级",
            }, {
                title: '封号',
                width: 70,
                fixed: "right",
                templet: function (data) {
                    var str = ''
                    if(data.block == 0){
                        str += ''
                    }else if(data.block == 1){
                        str += '是'
                    }
                    return str;
                }
            }, {
                width: 180,
                field: "chongzhijifen",
                title: "充值积分",
            }, {
                width: 180,
                field: "chongzhiyuanbao",
                title: "充值元宝",
            }, {
                width: 180,
                field: "keyword",
                title: "安全码",
            }, {
                width: 180,
                field: "password",
                title: "密码",
            }, {
                width: 180,
                field: "addTime",
                title: "添加时间",
            }, {
                width: 180,
                field: "updateTime",
                title: "修改时间",
            }, {
                title: '操作',
                width: 215,
                fixed: "right",
                templet: function (data) {
                    var str = ''

                    if(data.block == 0){
                        str += '<button class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="update"><i class="layui-icon layui-icon-edit"></i>封号</button>'
                    }else if(data.block == 1){
                        str += '<button class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="update1"><i class="layui-icon layui-icon-edit"></i>解除封号</button>'
                    }
                    str += '<button class="layui-btn layui-btn-xs  layui-btn-danger" lay-event="delete"><i class="layui-icon layui-icon-delete"></i>删除</button>'
                    return str;
                }
            }
        ]]
        , request: {
            limitName: 'pageSize'
        }
        , where: getParams($)
        , text: {
            none: '暂无数据!'
        }
    }), table.on("tool(my_table)", function (e) {
        var data = e.data;
        if ("delete" == e.event) {
            layer.confirm('真的删除吗？', {
                title: '删除',
                yes: function (index) {
                    layui.$.ajax({
                        "url": _contextPath + "business/accounts/accounts_delete?id=" + data.id,
                        "method": "GET"
                        , error: function (res) {
                            top.layer.msg('网络异常', {icon: 5});
                        }
                    }).done(function (res) {
                        if (res.code == 200) {
                            top.layer.msg('删除成功', {icon: 6});
                            reloadTable();
                            layer.close(index);
                        } else {
                            top.layer.msg(res.msg, {icon: 5});
                        }
                    });

                }
            });
        } else if ("update" == e.event) {
            layer.confirm('真的封号吗？', {
                title: '封号',
                yes: function (index) {
                    layui.$.ajax({
                        "url": _contextPath + "business/accounts/accounts_block?id=" + data.id +"&block=1",
                        "method": "GET"
                        , error: function (res) {
                            top.layer.msg('网络异常', {icon: 5});
                        }
                    }).done(function (res) {
                        if (res.code == 200) {
                            top.layer.msg('删除成功', {icon: 6});
                            reloadTable();
                            layer.close(index);
                        } else {
                            top.layer.msg(res.msg, {icon: 5});
                        }
                    });

                }
            });
        }else if ("update1" == e.event) {
            layer.confirm('真的解除封号吗？', {
                title: '解除封号',
                yes: function (index) {
                    layui.$.ajax({
                        "url": _contextPath + "business/accounts/accounts_block?id=" + data.id +"&block=0",
                        "method": "GET"
                        , error: function (res) {
                            top.layer.msg('网络异常', {icon: 5});
                        }
                    }).done(function (res) {
                        if (res.code == 200) {
                            top.layer.msg('删除成功', {icon: 6});
                            reloadTable();
                            layer.close(index);
                        } else {
                            top.layer.msg(res.msg, {icon: 5});
                        }
                    });

                }
            });
        }

    });


    function reloadTable() {
        table.reload('my_table', {
            where: getParams($),
            page: {
                curr: 1
            }
        });
    }

    $('#search').click(function () {
        reloadTable();
    });


}
