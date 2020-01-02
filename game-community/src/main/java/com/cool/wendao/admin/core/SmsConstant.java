package com.cool.wendao.admin.core;

public class SmsConstant {
    /************************************ 短信模板-start ************************************/
    /**
     * 商户管理平台认证失败模板
     * 阜平智慧旅游商户管理平台认证失败，请重新提交认证
     */
    public static final Integer ORG_REGISTER_FAILURE = 391277;

    /**
     * 商户管理平台认证成功通知模板
     * 您的商户已经成功通过阜平智慧旅游商户管理平台认证，请你及时登录平台发布您的产品信息
     */
    public static final Integer ORG_REGISTER_SUCCESS = 391275;

    /**
     * 商户管理平台注册验证码模板
     * {1}为您的阜平商户管理平台注册码，请于{2}分钟内填写。如非本人操作，请忽略此消息。
     */
    public static final Integer ORG_REGISTER_CODE = 387586;

    /**
     * 商户小程序忘记密码模板
     * 您正在通过手机号重置登录密码，短信验证码是{1},请于{2}分钟内填写。如非本人操作，请忽略此短信！
     */
    public static final Integer APP_FORGET_CODE = 396041;
    /************************************ 阜平短信模板-end  ************************************/

    /**
     * APP注册验证码模板
     * {1}为您的注册验证码，请于{2}分钟内填写，如非本人操作，请忽略此短信！
     */
    public static final Integer APP_REGISTER_CODE = 310705;

    /**
     * 审核通过后，发送小程序密码模板
     * 你的商户已经成功通过日照文旅商户平台的认证审核，你的商户小程序密码为{1}，请及时登录查看
     */
    public static final Integer SMALL_PROGRAM_PASSWORD = 315857;

}
