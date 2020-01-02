package com.cool.wendao.admin.server;

import com.cool.wendao.admin.core.ResultBean;

import java.util.List;

public interface MessageSendService {

    /**
     * 验证码短信
     * 根据模板里的{1}、{2}....设置对应的参数
     * @param mobile 发送号码
     * @param templateId 模板ID，支持模板见 SmsConstant 类的静态变量
     * @param params 参数数组，数据长度请严格匹配模板的参数个数。当模板中没有参数时，传null即可
     *
     *  以下参数为验证码模板时需要的参数，不是验证码模板 传null即可
     * @param code 当需要发送和校验验证码的时候，将验证码放到此参数中。
     * @param seconds 失效时间，单位秒
     * @return
     */
    ResultBean send(String mobile, Integer templateId, List<String> params, String code, Integer seconds);



    /**
     * 非验证码短信
     * 根据模板里的{1}、{2}....设置对应的参数
     * @param mobile 发送号码
     * @param templateId 模板ID，支持模板见 SmsConstant 类的静态变量
     * @param params 参数数组，数据长度请严格匹配模板的参数个数。当模板中没有参数时，传null即可
     * @return
     */
    ResultBean send(String mobile,Integer templateId, List<String> params);



    /**
     * 校验验证码是否正确
     * @param mobile 手机号
     * @param templateId  模板ID，模板ID，支持模板见 SmsConstant 类的静态变量
     *
     * @param code 待校验的验证码
     * @return
     */
    ResultBean validate(String mobile, Integer templateId, String code);
}
