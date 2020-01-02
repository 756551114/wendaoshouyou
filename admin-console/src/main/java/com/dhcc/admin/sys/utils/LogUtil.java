package com.dhcc.admin.sys.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

//import com.dhcc.admin.sys.config.ActivemqConfig;

public class LogUtil {

    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void sendLog(HttpServletRequest request, String moduleName, String operContent) {
//        try {
//            SysUser sysUser = SessionUtils.getUser(request);
//            BaseManageOperLog baseManageOperLog = new BaseManageOperLog();
//            baseManageOperLog.setId(UuidUtil.uuid());
//            baseManageOperLog.setModuleName(moduleName);
//            baseManageOperLog.setOperContent(operContent);
//            baseManageOperLog.setOperId(sysUser.getUserId());
//            baseManageOperLog.setOperName(StringUtils.isNotBlank(sysUser.getNickname()) ? sysUser.getNickname() : sysUser.getLoginName());
//            baseManageOperLog.setOperTime(new Date());
//            baseManageOperLog.setOperIp(IpUtil.getIpAddr(request));
//            //设置当前信息从商户平台发出来的
//            baseManageOperLog.setSysType(1);
//            baseManageOperLog.setOrgId(sysUser.getOrgId());
//            SpringUtils.getBean(ActivemqConfig.class).sendLog(SerializationUtils.serialize(baseManageOperLog));
//        } catch (Exception e) {
//            logger.error("操作日志发送失败", e);
//        }
    }
}
