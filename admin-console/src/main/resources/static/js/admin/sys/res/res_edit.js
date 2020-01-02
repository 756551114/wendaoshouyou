 function callback(){
	var $ = layui.$;
    var form = layui.form;

     form.verify({
         resName: function (value,item) {
             if (value.length > 20) {
                 return '长度不符合规范,超过20位';
             }
         },
         resUrl: function (value,item) {
             if (value.length > 200) {
                 return '长度不符合规范,超过200位';
             }
         }
     });

    if($('#iconPicker').length > 0){
    	var iconPicker = layui.iconPicker;
        iconPicker.render({
            // 选择器，推荐使用input
            elem: '#iconPicker',
            // 数据类型：fontClass/unicode，推荐使用fontClass
            type: 'fontClass',
            // 是否开启搜索：true/false
            search: false,
            // 点击回调
            click: function (data) {
                console.log(data);
            }
        });
        /**
         * 选中图标 （常用于更新时默认选中图标）
         * @param filter lay-filter
         * @param iconName 图标名称，自动识别fontClass/unicode
         */
        iconPicker.checkIcon('iconPicker', $('#iconPicker').val());
    }
 }