package com.cool.wendao.admin.core;

/**
 * 结果枚举
 *
 * @author caijy
 */
public enum ResultEnum {
    /**
     * 接口请求成功，返回200
     */
    SUCCESS(200, "操作成功"),
    SMS_CODE_INVALID(99991, "验证码不一致"),
    SMS_CODE_EXPIRED(99992, "验证码已失效"),
    NO_DATA(99993, "数据不存在"),
    EWM_FAIL(99994, "请提供正确的二维码"),
    SIGN_FAILED(99995, "非法请求,请刷新再试"),
    NOPARAMS(99996, "缺少必传参数"),
    LOGIN_FAILED(99997, "登录失效,请重新登录"),
    AUTH_FAILED(99998, "权限不足,请联系管理员开放权限"),
    TICKET_ERROR(900000,"门票系统繁忙,请稍后再试"),
    GOODS_ERROR(900001,"电商系统繁忙,请稍后再试"),
    HOTEL_ERROR(900002,"住宿系统繁忙,请稍后再试"),
    PROMOTION_ERROR(900003,"促销系统繁忙,请稍后再试"),
    PAY_ERROR(900004,"支付系统繁忙,请稍后再试"),
    ORG_ERROR(900005,"商户系统繁忙,请稍后再试"),
    ORDER_ERROR(900006,"订单系统繁忙,请稍后再试"),
    MEMBER_ERROR(900007,"会员系统繁忙,请稍后再试"),
    FOODS_ERROR(900008,"美食系统繁忙,请稍后再试"),
    CONTENT_ERROR(900009,"内容系统繁忙,请稍后再试"),
    COMMON_LOG_ERROR(900010,"通用日志系统繁忙,请稍后再试"),
    COMMON_ERROR(900011,"通用系统繁忙,请稍后再试"),
    APP_SERVER_ERROR(900012,"APP系统繁忙,请稍后再试"),
    MANAGE_ERROR(900013,"管理系统繁忙,请稍后再试"),
    POINTSMALL_ERROR(900014,"积分商城系统繁忙,请稍后再试"),
    SECKILL_ERROR(900015,"秒杀系统繁忙,请稍后再试"),
    NoPRODUCTINFORMATIONSET(900016,"未设置商品信息"),
    APPLETLOGINFAILED(900017,"小程序登录失败"),

    PWDERRO(30001, "帐户名或密码错误"),
    NOREGISTER(30002, "账号未注册"),
    REGISTED(30003, "账号已注册"),

    /**
     * 预留告警编码300,特殊告警可以用这个
     */
    WARN(300, ""),
    /**
     * 会员告警模块  30001-30200
     */
    MEMBER(30000, ""),
    MEMBERISNOTEXIST(30001, "用户不存在"),
    GET_CARDDETAIL_FAIL(30002, "获取会员卡详情失败"),
    GET_CARDINFO_FAIL(30003, "获取会员卡信息失败"),
    /**
     * 机构告警模块  30201-30400
     */
    ORG(30200, ""),
    GET_TICKETORGINFO_FAIL(30201, "获取门票商户信息失败"),
    GET_HOTELORGINFO_FAIL(30202, "获取住宿商户信息失败"),
    /**
     * 商品告警模块  30401-30600
     */
    GOODS(30400, ""),

    /**
     * 系统后台
     */
    MGT_ERROR(500, "网络异常"),


    /**
     * 格式错误
     */
    FILE_PATH_ISNULL(80000, "文件路径为空"),
    FILE_ISNULL(80001, "文件为空"),
    FILE_UPLOAD_FAILED(80002, "文件上传失败"),
    FILE_NOT_EXIST(80003, "文件不存在"),
    FILE_DOWNLOAD_FAILED(80004, "文件下载失败"),
    FILE_DELETE_FAILED(80005, "删除文件失败"),
    FILE_SERVER_CONNECTION_FAILED(80006, "文件服务器连接失败"),
    FILE_OUT_SIZE(80007, "文件超过大小"),
    FILE_TYPE_ERROR_IMAGE(80008, "图片类型错误"),
    FILE_TYPE_ERROR_DOC(80009, "文档类型错误"),
    FILE_TYPE_ERROR_VIDEO(80010, "音频类型错误"),
    FILE_TYPE_ERROR_COMPRESS(80011, "压缩文件类型错误"),
    /** 格式错误*/
    PIC_ERR(80012,"图片格式错误(必须为.jpg|.jpeg|.bmp|.png)"),
    VEDIO_ERR(80013,"视频格式错误 (必须为 .mp4|.flv|.avi|.rm|.rmvb|.wmv)"),
    VOICE_ERR(80014,"音频格式错误 (必须为 .mp3|.wav|.rmf|.midi|.aiff|.au)"),
    IMAGE_CONTENT_ERROR(80015,"图片内容错误"),
    FILE_NAME_ERROR(80016, "文件名称不能包含[\0]"),
    PIC_SIZE(80017, "图片大小不能超过4M!");

    private int code;
    private String msg;

    private ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

