$(function(){
	var account_url="http://new.816wd.com/";
	// 加载当前用户名
	$("#account").html('您的账号：'+jsObject.getUsername());
	//账号中心绑定手机
	$('body')
	//点击隐藏提示框
	.on('touchend','.common_popUp',function(){
		$('.common_popUp').fadeOut().addClass('hidden');
	})
	//删除账号
	.on('touchend','.register_headers dl dd .more_cont ul li i',function(){
		$(this).parent().remove();
		$('.register_headers dl dd .more_cont').addClass('hidden');
	})
	//查看更多账号
	.on('touchend','.register_headers dl dd .more',function(){
		var _show_div=$('.register_headers dl dd .more_cont');
		if(_show_div.hasClass('hidden')){
			_show_div.removeClass('hidden');
		}else{
			_show_div.addClass('hidden');
		}
	})
	//登入
	.on('touchend','.register_headers dl dd .common_btn',function(){
		popup_fn('密码错误');
	})
	//弹出层
	var setTime_time=null;
	function popup_fn(msg){
		$('.common_popUp p').html(msg).parent().fadeIn(30).removeClass('hidden');
		setTime_time=setInterval(function(){
			$('.common_popUp').fadeOut(30).addClass('hidden');
		},3000);
	};
	//绑定身份证,先验证是否绑定手机
	$('.account_center_change ul li:eq(3)')
	.on('touchend',function(){
		var url=account_url+"terrace/mobile/getPhoneBindMessage.do";
		var data={"username":jsObject.getUsername(),"sid":jsObject.getSid(),"cookie":jsObject.getCookie()};
		send_fn(url,data,function(result){
			if(result.status == "1"){
				check_idcard(result.bindPhone);
			}else if(result.status == "2"){
				jsObject.showMsg('当前账号未绑定手机，请先绑定');
			}else{
				popup_fn('当前手机网络异常，请切换网络重试!');
			}
		});
	})
	//检查是否已绑定身份证
	function check_idcard(phoneNum){
		var url=account_url+"terrace/mobile/checkIdCardExist.do";
		var data={"sid":jsObject.getSid(),"cookie":jsObject.getCookie()};
		send_fn(url,data,function(result){
			if(result.status == "1"){
				jsObject.showMsg("此账号已绑定身份证");
			}else if(result.status == "2"){
				location.href='bind_idcard.html?phoneNum='+phoneNum;
			}else{
				popup_fn('当前手机网络异常，请切换网络重试!');
			}
		});
	};
	//通用发送
	function send_fn(url,data,callback){
		$.ajax({
			type:"get",
			url:url,
			data:data,
			dataType:'jsonp',
			jsonp:'jsonpcallback',
			success:function(result){
				callback(result);
			},
			error:function(result){
				popup_fn('当前手机网络异常，请切换网络重试!');
			}
		});
	};
})