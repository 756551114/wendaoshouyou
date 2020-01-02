package com.cool.wendao.manager.admin.sys.utils;

import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 导出工具
 * @author Fangbb
 * 2019-04-19
 */
public class ExcelUtil {

    /**
     *
     * @Title: encodeFileName
     * @Description: 导出文件转换文件名称编码
     * @param @param fileNames
     * @param @param request
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String encodeFileName(String fileNames , HttpServletRequest request) {
        String codedFilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE") || null != agent
                    && -1 != agent.indexOf("Trident") || null != agent && -1 != agent.indexOf("Edge")) {// ie浏览器及Edge浏览器
                String name = java.net.URLEncoder.encode(fileNames, "UTF-8");
                codedFilename = name;
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,Chrome等浏览器
                codedFilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedFilename ;
    }

    //生成模板,也支持模板数据
    public static <T> boolean generateSheet(List<T> listBean, Map<String,String> titleMap, OutputStream out){
        boolean flag = true;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();//这个是生成xlsx文件
            XSSFSheet sheet = workbook.createSheet();
            XSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
            style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
            style.setBorderRight(XSSFCellStyle.BORDER_THIN);
            style.setBorderTop(XSSFCellStyle.BORDER_THIN);
            style.setAlignment(XSSFCellStyle.ALIGN_CENTER);

            //产生表格标题行
            XSSFRow row = sheet.createRow(0);
            int i = 0;
            for (Map.Entry<String, String> m : titleMap.entrySet()) {
                XSSFCell cell = row.createCell(i);
                //        	cell.setCellStyle(style);//设置标题行风格
                XSSFRichTextString text = new XSSFRichTextString(m.getValue());
                cell.setCellValue(text);
                i++;
            }
            if(listBean != null && listBean.size()!=0){
                //生成数据
                for (int index = 0; index < listBean.size(); index++) {
                    row = sheet.createRow(index + 1);
                    T t = (T) listBean.get(index);
                    int j = 0;
                    for (Map.Entry<String, String> m : titleMap.entrySet()) {
                        XSSFCell cell = row.createCell(j);
                        String fieldName = m.getKey();//传递过来的字段名

                        String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);
                        Method getMethod = t.getClass().getMethod(getMethodName, new Class[]{});
                        Object value = getMethod.invoke(t, new Object[]{});
                        String textValue = null;
                        if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(
                                    "yyyy-MM-dd HH:mm:ss");
                            textValue = sdf.format(date);
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            if (value == null) {
                                value = "";
                            }
                            textValue = String.valueOf(value);
                        }
                        cell.setCellValue(textValue);
                        j++;
                    }
                }
            }
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return flag;
    }
}
