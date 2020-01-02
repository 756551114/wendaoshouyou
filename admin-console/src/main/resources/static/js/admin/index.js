 function callback(){
	var $ = layui.$;
	 function getQueryString(name) {
		 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		 var r = window.location.search.substr(1).match(reg);
		 if (r != null) return unescape(r[2]);
		 return null;
	 }
	 var defOpenType = getQueryString("defOpenType");
	 if(defOpenType){
		 if(defOpenType==1){//跳转商户认证
		 	$("#LAY-system-side-menu>li").each(function () {
				var resName = $(this).children("a").attr("lay-tips");
				if(resName=="商户信息管理"){
					$(this).addClass("layui-nav-itemed");
				}
			});
			 top.layui.index.openTabsPage(_contextPath + 'business/merchant/mrch_check_index', '商户认证');
		 }
	 }
}