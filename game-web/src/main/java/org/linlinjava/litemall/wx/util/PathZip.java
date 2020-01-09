package org.linlinjava.litemall.wx.util;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.ZipUtil;
import org.linlinjava.litemall.wx.core.Inint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;

public class PathZip {

    public static void  patch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=patch.zip");
            String pathZip = "/home/temp/patch.zip";
            boolean exist = FileUtil.exist(pathZip);
            if(!exist) {
                ZipUtil.unzip("path/patch.zip", "/home/temp/path");
                String distLua = "/home/temp/path/patch/dist.lua";
                FileWriter writer = new FileWriter(distLua);
                writer.write("return {\n" +
                        "  [\"default\"] = {\n" +
                        "        ver = \"2.040r.0702\",\n" +
                        "        dist = \"涅槃重生\",\n" +
                        "        ftpHost = \"127.0.0.1\",\n" +
                        "        ftpPort = \"21\",\n" +
                        "        ftpUser = \"atm\",\n" +
                        "        ftpPwd = \"\",\n" +
                        "        accList = {\"110001runlmv6i\",\"110001ies8gr3v\",\"110001ikurjy1h\",\"110001mu07vmpk\",\"110001gs455hit\"},\n" +
                        "        service_infos = {\n" +
                        "              { [\"key\"] = \"qq\", [\"value\"] = {} },\n" +
                        "              { [\"key\"] = \"qq_group\", [\"value\"] = {} },\n" +
                        "              { [\"key\"] = \"wx\", [\"value\"] = {} },\n" +
                        "              { [\"key\"] = \"tel\", [\"value\"] = {} },\n" +
                        "        },\n" +
                        "        new_package_first_version = \"2.040r.0702\",\n" +
                        "        force_update_version = \"2.040r.0702\",\n" +
                        "        update_package_time = \"2018-01-25 04:59:59\",\n" +
                        "    },\n" +
                        "\n" +
                        "  [\"groups\"] ={\n" +
                        "       \"" + Inint.groups + "\",},\n" +
                        Inint.groupsL +
                        "}\n");
                ZipUtil.zip("/home/temp/path/patch", pathZip, true);
            }
            BufferedInputStream inputStream = FileUtil.getInputStream(pathZip);
            IoUtil.copy(inputStream, response.getOutputStream(), IoUtil.DEFAULT_BUFFER_SIZE);
            response.getOutputStream().flush();
        } catch (UtilException e) {
            e.printStackTrace();
        } catch (IORuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.getOutputStream().close();
        }
    }
}
