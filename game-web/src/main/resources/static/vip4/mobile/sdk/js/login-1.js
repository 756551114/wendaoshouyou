/*
*/
$(function () {
    // 加载当前用户名
    $("#account").html('当前登录账号：' + jsObject.getUsername());
    // 根目录
    var login_url = "http://192.168.1.188:81/vip4/mobile/sdk/";
    // 注册方式
    var mode;
    var type;
    var verification_code = null;  //当前验证码
    var verification_number = null; //验证号码
    var bindname;//绑定雷霆账号名
    var updataname;//升级雷霆账号

    var reg = {
        "phone": /^1\d{9,11}$/,
        "email": /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/,
        "pwd": /^\w{6,32}$/,
        "account": /^[0-9a-zA-Z]+$/,
        "chineseChar": /^[\u4e00-\u9fa5]+$/
    }

    var confirm_register_fn_sta = false;
    var isWaitForResponse = false;

    //确定注册
    function confirm_register_fn(userName, passWord, superPass, obj) {
        // 处理按钮
        if (confirm_register_fn_sta) {
            return;
        }
        confirm_register_fn_sta = true;
        var AgetChannelNo = jsObject.getChannelNo() || '110001';
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!mobileRegisterNew.action",
            data: {
                "mobile.username": userName,
                "mobile.password": jsObject.getDesPwd(passWord),
                "mobile.serial": jsObject.getSerial(),
                "mobile.game": jsObject.getGame(),
                "mobile.channelNo": AgetChannelNo,
                "mobile.cookie": jsObject.getRegisterCookie(userName, jsObject.getDesPwd(passWord)),
                "mobile.regMethod": mode,
                "mobile.os": jsObject.getOs(),
                "mobile.phoneModel": jsObject.getPhoneModel(),
                "mobile.media": jsObject.getMedia(),
                "code": verification_code,
                "phonenumber": verification_number,
                "superPass": superPass,
            },
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
//				data={"IsSuccess":true};
                if (data.IsSuccess) {
                    obj.addClass('hidden');
                    $('.login_succ').removeClass('hidden');
                    if ("registerResult" in jsObject) {
                        var result = {};
                        result.username = userName;
                        result.userId = data.sid;
                        jsObject.registerResult(JSON.stringify(result));
                    }
                } else {
                    popup_fn(data.Msg);
                    confirm_register_fn_sta = false;
                }
            },
            error: function (data) {
//				data={"IsSuccess":true};
                if (data.IsSuccess) {
                    obj.addClass('hidden');
                    $('.login_succ').removeClass('hidden');
                } else {
                    popup_fn(data.Msg);
                }
                confirm_register_fn_sta = false;
            }
        });
    }


    var TestGetCode_status = true;
    $('body')
    //同意协议
        .on('touchend', '.common_ulPraent ul li.agree i', function () {
            if ($(this).parents('li').find('input').prop('checked')) {
                $(this).parents('li').find('input').prop('checked', false);
                $(this).removeClass('active');
            } else {
                $(this).parents('li').find('input').prop('checked', true);
                $(this).addClass('active');
            }
        })
        //密码的状态显示隐藏
        .on('touchend', '.show_password', function () {
            var oInput = $(this).parents('li').find('.common_text');
            if (oInput.attr('type') == 'text') {
                oInput.attr('type', 'password');
                $(this).text('显示');
            } else {
                oInput.attr('type', 'text');
                $(this).text('隐藏');
            }
        })
        //邮箱注册获取验证码
        .on('touchend', '.getVerifyCode .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.val() != '') {
                if (reg['phone'].test(_this.val())) {
                    verification_number = _this.val();
                    var url = login_url + "login/mobile_two!getRegisterCodeOnly.action";
                    var data = {
                        "phonenumber": _this.val(),
                        "game": jsObject.getGame(),
                        "cookie": jsObject.getCookie(_this.val())
                    };
                    send_fn('email', url, data, function () {
                        $('.getVerifyCode').addClass('hidden');
                        $('.setPassword').removeClass('hidden');
                        count_down($('.setPassword').find('p.time'), 60, 'email', 'Register');
                        //引导实名认证，注册时不强制实名
                        if ("getAuthGuide" in jsObject && jsObject.getAuthGuide() == '0') {
                            $('#realname').addClass('hidden');
                            $('#idCard').addClass('hidden');
                        }
                    });
                    return;
                } else {
                    popup_fn('输入正确的手机号');
                }

            } else {
                popup_fn('请输入手机号');
            }
        })
        //确定手机注册
        // .on('touchend','.setPassword .common_btn',function(){
        //     var _this=$(this).parents('ul').find('.common_text');
        // 	if(_this.eq(1).val()!=''){
        // 		if(_this.eq(0).val()=='' || _this.eq(0).val().length!=4 && _this.eq(0).val().length!=5){
        // 			popup_fn('请输入正确的验证码');
        // 			return;
        // 		}
        // 		if(_this.eq(1).val().length<6){
        // 			popup_fn('设置的登录密码必须大于六位数');
        // 			return;
        // 		}
        // 		if(!reg['pwd'].test(_this.eq(1).val())){
        // 			popup_fn('请设置含数字英文下划线密码');
        // 			return;
        // 		}
        // 		verification_code=_this.eq(0).val();
        // 		if($('#idCard').is(":visible")){
        // 			if(!validateIdCard(_this.eq(3).val())){
        // 				popup_fn('身份证号码输入有误，请重新输入！');
        // 				return;
        // 			}
        // 			if(!reg['chineseChar'].test(_this.eq(2).val())){
        // 				popup_fn('请输入中文姓名');
        // 				return;
        // 			}
        // 			if(_this.eq(2).val().length<2 || _this.eq(2).val().length>20){
        // 				popup_fn('您输入的姓名长度不符合要求，请重新输入！');
        // 				return;
        // 			}
        // 			confirm_register_fn($('.TestGetCode .common_text').val(),_this.eq(1).val(),_this.eq(2).val(),_this.eq(3).val(),$('.setPassword'));
        // 		}else{
        // 			//引导实名认证，注册时不强制实名
        // 			confirm_register_fn($('.TestGetCode .common_text').val(),_this.eq(1).val(),'','',$('.setPassword'));
        // 		}
        // 	}else{
        // 		popup_fn('请设置登录密码');
        // 	}
        // })

        .on('touchend', '.setPassword .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.eq(0).val() != '') {
                if (!reg['account'].test(_this.eq(0).val())) {
                    popup_fn('你输入的账号格式错误');
                    return;
                }
                if (_this.eq(2).val().length < 6) {
                    popup_fn('设置的登录密码必须大于六位数');
                    return;
                }
                if (!reg['pwd'].test(_this.eq(2).val())) {
                    popup_fn('请设置含数字英文下划线密码');
                    return;
                }
                if (_this.eq(3).val().length < 8) {
                    popup_fn('设置的超级密码必须大于八位数');
                    return;
                }
                if (_this.eq(3).val() !== _this.eq(4).val()) {
                    popup_fn('两次超级密码输入不一致，请重新输入');
                    return;
                }
                if (_this.eq(3).val() === _this.eq(2).val()) {
                    popup_fn('登录密码不能和超级密码相同');
                    return;
                }
                verification_code = _this.eq(1).val();
                //引导实名认证，注册时不强制实名
                confirm_register_fn(_this.eq(0).val(), _this.eq(2).val(), _this.eq(3).val(), $('.setPassword'));
            } else {
                popup_fn('请设置登录密码');
            }
        })
        //确定注册 使用手机升级雷霆账号
        .on('touchend', '.confirm_register .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.eq(0).val() == '') {
                popup_fn('输入的验证码为空');
                return;
            }
            if (_this.eq(1).val() != '') {
                if (_this.eq(1).val().length < 6) {
                    popup_fn('设置的登录密码必须大于六位数');
                    return;
                }
                if (!reg['pwd'].test(_this.eq(1).val())) {
                    popup_fn('请设置含数字英文下划线密码');
                    return;
                }
                if (!validateIdCard(_this.eq(3).val())) {
                    popup_fn('身份证号码输入有误，请重新输入！');
                    return;
                }
                if (!reg['chineseChar'].test(_this.eq(2).val())) {
                    popup_fn('请输入中文姓名');
                    return;
                }
                if (_this.eq(2).val().length < 2 || _this.eq(2).val().length > 20) {
                    popup_fn('您输入的姓名长度不符合要求，请重新输入！');
                    return;
                }
                verification_code = _this.eq(0).val();
                update_send_fn($('.upgrade_userName .common_text').val(), _this.eq(1).val(), _this.eq(2).val(), _this.eq(3).val(), $('.confirm_register'));

            } else {
                popup_fn('请设置登录密码');
            }
        })
        //校验
        .on('touchend', '.TestGetCode .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (!TestGetCode_status) return;
            TestGetCode_status = false;
            if (_this.val() != '') {
                if (!$('.TestGetCode ul li.agree input').prop('checked')) {
                    popup_fn('阅读并同意《雷霆通行证服务条款》');
                    return;
                }
                var url = login_url + "login/mobile_two!getRegisterCode.action";
//			if(reg['email'].test(_this.val())){
//				var val=_this.val().toLowerCase();
//				var data={"username":val,"mode":'email',"game":jsObject.getGame(),"cookie":jsObject.getCookie(val)};
//				send_fn('email',url,data,function(){
//					$('.TestGetCode').addClass('hidden');
//					$('.getVerifyCode').removeClass('hidden');
//				});
//			}else 
                if (reg['phone'].test(_this.val())) {
                    verification_number = _this.val();
                    var data = {
                        "username": verification_number,
                        "mode": 'phone',
                        "game": jsObject.getGame(),
                        "cookie": jsObject.getCookie(verification_number)
                    };
                    send_fn('phone', url, data, function () {
                        $('.TestGetCode').addClass('hidden');
                        $('.setPassword').removeClass('hidden');
                        //引导实名认证，注册时不强制实名
                        if ("getAuthGuide" in jsObject && jsObject.getAuthGuide() == '0') {
                            $('#realname').addClass('hidden');
                            $('#idCard').addClass('hidden');
                        }
                        count_down($('.setPassword').find('p.time'), 60, 'email', 'Register');


                        TestGetCode_status = true;
                    });
                } else {
                    popup_fn('输入正确的手机号');
                }

            } else {
                popup_fn('请输入手机号');
            }
        })
        //点击隐藏提示框
        .on('touchend', '.common_popUp', function () {
            $('.common_popUp').fadeOut().addClass('hidden');
        })
        //重新发送验证码
        .on('touchend', '.anew_send', function () {
            switch ($(this).attr('data-type')) {
                case 'Register'://重发验证码
                    var url = login_url + "login/mobile_two!getRegisterCodeOnly.action";
                    var data = {
                        "phonenumber": verification_number,
                        "game": jsObject.getGame(),
                        "cookie": jsObject.getCookie(verification_number)
                    };
                    send_fn(mode, url, data, function () {
                        count_down($('.setPassword').find('p.time'), 60, mode, 'Register');
                    });
                    break;
                case 'Findpwd'://找回密码
                    fpwd_send_fn('phone', $('.setNewPassword'), $('.find_userName'), bindname);
                    break;
                case 'phoneUpdrade'://手机升级雷霆账号
                    upgrade_send_fn('phone', $('.confirm_register'), $('.upgrade_userName'), updataname);
                    break;
            }
        })
        //校验验证码
        .on('touchend', '.email_phone .common_btn', function () {
            if (!$(this).parents('ul').find('.common_text').val()) {
                popup_fn('请输入验证码');
                return;
            }
            ;

            $(this).parents('ul').find('.common_text').val() == verification_code

            switch ($(this).attr('data-status')) {
                case 'find_password'://找回密码
                    $('.setNewPassword').removeClass('hidden');
                    break;
                case 'login'://登录
                    $('.setPassword').removeClass('hidden');
                    break;
                case 'chnage_password'://修改密码
                    $('.changeNewPassword').removeClass('hidden');
                    break;
                case 'confirm_register'://使用手机升级雷霆账号
                    $('.confirm_register').removeClass('hidden');
                    break;
            }
            $(this).parents('.email_phone').addClass('hidden');
            clearInterval(time);
        })

        //修改密码查看是否有该账号
        .on('touchend', '.change_userName .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.val() != '') {
//			if(reg['email'].test(_this.val())){
//				test_passWord_find_fn('email',$('.email'),$('.change_userName'),_this.val());
//				return;
//			}
                if (reg['phone'].test(_this.val())) {
                    var username = null;
                    var bojs = location.href.split('?')[1].split('&');
                    for (var i = 0; i < bojs.length; i++) {
                        if (bojs[i].indexOf('userName') != -1) {
                            username = bojs[i].split('=')[1];
                        }
                    }
                    test_passWord_find_fn('phone', $('.changeNewPassword'), $('.change_userName'), _this.val(), username);
                    return;
                } else {
                    popup_fn('输入正确的手机号');
                }

            } else {
                popup_fn('请输入账号绑定的手机号');
            }
        })
        //找回密码 新密码 输入是否一致
        .on('touchend', '.setNewPassword .common_btn', function () {
            var aInput = $(this).parents('ul').find('.common_text');
            if (aInput.eq(0).val() === '') {
                popup_fn('请输入账号');
                return;
            }
            if (aInput.eq(1).val() === '') {
                popup_fn('请输入超级密码');
                return;
            }
            if (aInput.eq(2).val().length < 6 || aInput.eq(3).val().length < 6) {
                popup_fn('设置的登录密码必须大于六位数');
                return;
            }
            if (!reg['pwd'].test(aInput.eq(2).val()) || !reg['pwd'].test(aInput.eq(2).val())) {
                popup_fn('请设置含数字英文下划线密码');
                return;
            }
            if (aInput.eq(2).val() !== aInput.eq(3).val()) {
                popup_fn('您两次密码输入不一致，请重新输入');
                return;
            } else {
                // 追加参数
                var newPwd = aInput.eq(2).val();
                var account = aInput.eq(0).val();
                var superPass = aInput.eq(1).val();                
                sen_new_password_fn_new($('.setNewPassword'), account, superPass, newPwd)
            }
        })
        //修改密码 输入是否一致 以及认证原始密码
        .on('touchend', '.changeNewPassword .common_btn', function () {
            var aInput = $(this).parents('ul').find('.common_text');
            if (aInput.eq(0).val() === '') {
                popup_fn('您输入验证码为空');
                return;
            }
            if (aInput.eq(1).val() === '' || aInput.eq(2).val() === '') {
                popup_fn('您输入新密码为空');
                return;
            }
            if (aInput.eq(1).val().length < 6 || aInput.eq(2).val().length < 6) {
                popup_fn('设置的登录密码必须大于六位数');
                return;
            }
            if (!reg['pwd'].test(aInput.eq(1).val()) || !reg['pwd'].test(aInput.eq(2).val())) {
                popup_fn('请设置含数字英文下划线密码');
                return;
            }
            if (aInput.eq(1).val() !== aInput.eq(2).val()) {
                popup_fn('您两次密码输入不一致，请重新输入');
                return;
            } else {
                var username = null;
                var bojs = location.href.split('?')[1].split('&');
                for (var i = 0; i < bojs.length; i++) {
                    if (bojs[i].indexOf('userName') !== -1) {
                        username = bojs[i].split('=')[1];
                    }
                }
//			verification_code=aInput.eq(0).val();
                // 追加参数
                var mode = "phone";
                var bindname = $('.change_userName .common_text').val();
                var newPwd = aInput.eq(1).val();
                sen_new_password_fn($('.changeNewPassword'), mode, bindname, username, newPwd, aInput.eq(0).val());

            }
        })

        .on('touchend', '.upgrade_userName .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.val() !== '') {
                if (!$('.upgrade_userName ul li.agree input').prop('checked')) {
                    popup_fn('阅读并同意《雷霆通行证服务条款》');
                    return;
                }
                if (reg['phone'].test(_this.val())) {
                    upgrade_send_fn('phone', $('.confirm_register'), $('.upgrade_userName'), $('.upgrade_userName .common_text').val());
                    return;
                } else {
                    popup_fn('输入正确的手机号');
                }

            } else {
                popup_fn('请输账号绑定的手机号码');
            }
        })
        //	校验要找回密码的账号是否存在  2016年3月17日
        .on('touchend', '.TestUsernameTrus .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.val() !== '') {
//			$.ajax({
//				type:"get",
//				url:login_url+"",
//				data:{"username":_this.val(),"game":jsObject.getGame(),"os":"1","cookie":jsObject.getCookie(_this.val())},
//				dataType:'jsonp',
//				jsonp:'jsonpcallback',
//				success:function(data){
//					if(data.IsSuccess){
                $('.TestUsernameTrus').addClass('hidden');
                $('.find_userName').removeClass('hidden');
//					}else{
//						popup_fn(data.Msg);
//					}
//				}, 
//				error:function(data){
//					popup_fn('网络错误');
//				}
//			});
            } else {
                popup_fn('请输入要找回的账号');
            }
        })
        //该绑定账号是否存在
        .on('touchend', '.find_userName .common_btn', function () {
            var _this = $(this).parents('ul').find('.common_text');
            if (_this.val() != '') {
//			if(reg['email'].test(_this.val())){
//				test_passWord_fn('email',$('.email'),$('.find_userName'),_this.val());
//				return;
//			}
                if (reg['phone'].test(_this.val())) {
                    test_passWord_fn('phone', $('.setNewPassword'), $('.find_userName'), _this.val());
                    return;
                } else {
                    popup_fn('输入正确的手机号');
                }

            } else {
                popup_fn('请输入手机号');
            }
        })

    // 切换账号
    $('#switchAccount').on('click', function () {
        jsObject.switchAccount();
    });

    // 联系客服
    $('#findGm').on('click', function () {
        jsObject.findGm();
    });

    //显示雷霆通行证服务条款
    $('#protocolPhone').on('click', function () {
        jsObject.goProtocol();
    });

    //显示雷霆通行证服务条款
    $('#protocolPhone1').on('click', function () {
        jsObject.goProtocol();
    });

    //显示雷霆通行证服务条款
    $('#protocolPhone2').on('click', function () {
        jsObject.goProtocol();
    });

    $('#backBtn').on('click', function () {
        jsObject.cancel();
    });

    function sen_new_password_fn_new(obj, account, superPass, newPassword) {
        $.ajax({
            // type: "get",
            url: login_url + "Retrieve_password.php",
            data: {
                "account": account,
                "pwd": jsObject.getDesPwd(newPassword),
                "safe": superPass,
            },
            dataType: 'json',
            success: function (data) {
                if (data.IsSuccess) {
                    setTimeout(function () {
                        jsObject.switchAccount();
                    }, 1500);
                    obj.addClass('hidden');
                    $('.login_succ').removeClass('hidden');

                } else {
                    popup_fn(data.Msg);
                }
            },
            error: function (data) {
                popup_fn(data.Msg);
            }
        });
    }

    //找回密码已经修改密码 发送新的账号密码
    function sen_new_password_fn(obj, mode, bindname, username, newPwd, code) {
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!modifyPwdInterFace.action",
            data: {
                "username": username,
                "newPwd": jsObject.getDesPwd(newPwd),
                "mode": mode,
                "bindname": bindname,
                "code": code,
                "cookie": jsObject.getCodeCookie(code)
            },
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    obj.addClass('hidden');
                    $('.login_succ').removeClass('hidden');
                } else {
                    popup_fn(data.Msg);
                }
            },
            error: function (data) {
                popup_fn(data.Msg);
            }
        });
    }

    //弹出层
    var setTime_time = null;

    function popup_fn(msg) {
        clearInterval(setTime_time);
        $('.common_popUp p').html(msg).parent().fadeIn(30).removeClass('hidden');
        setTime_time = setInterval(function () {
            $('.common_popUp').fadeOut(30).addClass('hidden');
            clearInterval(setTime_time);
        }, 3000);

        //校验点击重置
        TestGetCode_status = true;
    };
    //倒计时
    var time = null;

    function count_down(obj, time_number, statuS, type) {
        time = setInterval(function () {
            time_number--;
            if (time_number <= 0) {
                clearInterval(time);
                obj.html('超时？<span class="anew_send" data-statuS="' + statuS + '" data-type="' + type + '">重新发送</span>');
                return;
            }
            ;
            obj.html('<span>' + time_number + '</span>秒重新发送');
        }, 1000);
    };

    //发送验证码
    function anew_send_fn(statuS, obj, superior, val) {
        mode = statuS;
        // 账号名统一转小写，不然校验值会出问题
        val = val.toLowerCase();
        //当前状态 statuS
        //当前要显示的DIV  obj
        //当前要隐藏的DIV  superior
        //当前账号  val
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!getRegisterCode.action",
            data: {"username": val, "mode": statuS, "game": jsObject.getGame(), "cookie": jsObject.getCookie(val)},
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    if (statuS == 'email') {
                        superior.addClass('hidden');
                        $('.mailpassword').removeClass('hidden');
                        obj.find('h3').html('您的邮箱号:' + val);
                        count_down(obj.find('p.time'), 60, 'email', 'Register');
                    } else if (statuS == 'phone') {
                        superior.addClass('hidden');
                        obj.removeClass('hidden');
                        obj.find('h3').html('您的手机号:' + val);
                        count_down(obj.find('p.time'), 60, 'email', 'Register');
                    }
                } else {
                    popup_fn(data.Msg);
                }
            },
            error: function (data) {
                popup_fn(data.Msg);
            }
        });
    };

    //通用发送
    function send_fn(statuS, url, data, callback) {
        if (isWaitForResponse) {
            return;
        } else {
            isWaitForResponse = true;
        }
        //当前状态 statuS
        mode = statuS;

        $.ajax({
            type: "get",
            url: url,
            data: data,
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    callback();
                } else {
                    popup_fn(data.Msg);
                }
                isWaitForResponse = false;
            },
            error: function (data) {
                popup_fn(data.Msg);
                isWaitForResponse = false;
            }
        });
    };

    //校验该账号是否绑定了账号(修改密码专用)
    function test_passWord_find_fn(statuS, obj, superior, val, uname) {
        if (isWaitForResponse) {
            return;
        } else {
            isWaitForResponse = true;
        }
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!checkBindInfo.action",
            data: {"bindname": val, "username": uname},
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    fpwd_send_fn(statuS, obj, superior, val);
                } else {
                    popup_fn(data.Msg);
                }
                isWaitForResponse = false;
            },
            error: function (data) {
                popup_fn(data.Msg);
                isWaitForResponse = false;
            }
        });
    }

    //校验该账号是否绑定了账号(找回密码专用)
    function test_passWord_fn(statuS, obj, superior, val) {
        if (isWaitForResponse) {
            return;
        } else {
            isWaitForResponse = true;
        }
        var uname = $('.TestUsernameTrus').find('.common_text').val();
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!checkBindInfo.action",
            data: {"bindname": val, "username": uname},
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    fpwd_send_fn(statuS, obj, superior, val);
                } else {
                    popup_fn(data.Msg);
                }
                isWaitForResponse = false;
            },
            error: function (data) {
                popup_fn(data.Msg);
                isWaitForResponse = false;
            }
        });
    }

    //获取找回密码的验证码
    function fpwd_send_fn(statuS, obj, superior, val) {
        mode = statuS;
        bindname = val;
        //当前状态 statuS
        //当前要显示的DIV  obj
        //当前要隐藏的DIV  superior
        //当前账号  val
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!getFindpwdCode.action",
            data: {"bindname": val, "mode": statuS},
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    superior.addClass('hidden');
                    obj.removeClass('hidden');
                    if (statuS == 'email') {
                        obj.find('h3').html('您的邮箱号:' + val);
                        count_down(obj.find('p.time'), 60, 'email', 'Findpwd');
                    } else if (statuS == 'phone') {
                        obj.find('h3').html('您的手机号:' + val);
                        count_down(obj.find('p.time'), 60, 'email', 'Findpwd');
                    }
                } else {
                    popup_fn(data.Msg);
                }
            },
            error: function (data) {
                popup_fn(data.Msg);
            }
        });
    };

    //获取手机升级雷霆账号的验证码
    function upgrade_send_fn(statuS, obj, superior, val) {
        if (isWaitForResponse) {
            return;
        } else {
            isWaitForResponse = true;
        }
        mode = statuS;
        updataname = val
        //当前状态 statuS
        //当前要显示的DIV  obj
        //当前要隐藏的DIV  superior
        //当前账号  val
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!phoneUpdradeKey.action",
            data: {"username": val, "mode": statuS, "cookie": jsObject.getCookie(), "sid": jsObject.getSid()},
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    superior.addClass('hidden');
                    obj.removeClass('hidden');
                    if (statuS == 'email') {
                        obj.find('h3').html('您的邮箱号:' + val);
                        count_down(obj.find('p.time'), 60, 'email', 'phoneUpdrade');
                    } else if (statuS == 'phone') {
                        obj.find('h3').html('您的手机号:' + val);
                        count_down(obj.find('p.time'), 60, 'email', 'phoneUpdrade');
                    }
                } else {
                    popup_fn(data.Msg);
                }
                isWaitForResponse = false;
            },
            error: function (data) {
                if (data.IsSuccess) {

                } else {
                    popup_fn(data.Msg);
                }
                isWaitForResponse = false;
            }
        });
    };

    //使用手机升级雷霆账号
    function update_send_fn(userName, passWord, realName, idCard, obj) {
        $.ajax({
            type: "get",
            url: login_url + "login/mobile_two!upgradePhone.action",
            data: {
                "mobile.username": userName,
                "mobile.cookie": jsObject.getCodeCookie(verification_code),
                "mobile.sid": jsObject.getSid(),
                "mobile.password": jsObject.getDesPwd(passWord),
                "mobile.game": jsObject.getGame(),
                "code": verification_code,
                "realName": realName,
                "idCard": idCard
            },
            dataType: 'jsonp',
            jsonp: 'jsonpcallback',
            success: function (data) {
                if (data.IsSuccess) {
                    obj.addClass('hidden');
                    $('.login_succ').removeClass('hidden');
                    if ("bindResult" in jsObject) {
                        jsObject.bindResult(true);
                    }
                } else {
                    popup_fn(data.Msg);
                }
            },
            error: function (data) {
                popup_fn(data.Msg);
            }
        });

    }

    //验证身份证号码合法性
    function validateIdCard(idCard) {
        //15位和18位身份证号码的正则表达式
        var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;

        //如果通过该验证，说明身份证格式正确，但准确性还需计算
        if (regIdCard.test(idCard)) {
            if (idCard.length == 18) {
                var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
                var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
                var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
                for (var i = 0; i < 17; i++) {
                    idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
                }

                var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
                var idCardLast = idCard.substring(17);//得到最后一位身份证号码

                //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
                if (idCardMod == 2) {
                    if (idCardLast == "X" || idCardLast == "x") {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                    if (idCardLast == idCardY[idCardMod]) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    };

    // 判断是否显示联系客服按钮
    function isShowGm() {
        if (!"isShowGm" in jsObject) {
            $('#findGm_parent').show();
            return;
        }
        jsObject.isShowGm() ? $('#findGm_parent').show() : $('#findGm_parent').hide();
    }

    isShowGm();
})