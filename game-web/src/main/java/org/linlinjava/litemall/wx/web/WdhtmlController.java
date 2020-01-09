package org.linlinjava.litemall.wx.web;


import org.linlinjava.litemall.wx.util.PathZip;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Controller
@RequestMapping
public class WdhtmlController {

    private int width = 120;// 定义图片的width
    private int height = 40;// 定义图片的height
    private int codeCount = 4;// 定义图片上显示验证码的个数
    private int xx = 21;
    private int fontHeight = 31;
    private int codeY = 26;
    char[] codeSequence = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    @Value("${netty.url}")
    private String url;



    @GetMapping("/vip4/mobile/sdk/register.html")
    public String register(HttpServletRequest request) {
        request.setAttribute("url", url);
        return "register";
    }

    @GetMapping("/vip4/mobile/sdk/find_password.html")
    public String findPassword(HttpServletRequest request) {
        request.setAttribute("url", url);
        return "find_password";
    }




    @GetMapping("/vip4/mobile/sdk/account_center.html")
    public String accountCenter(HttpServletRequest request) {
        request.setAttribute("url", url);
        return "account_center";
    }


    @GetMapping("/vip4/mobile/sdk/captcha.php")
    @ResponseBody
    public void captcha(HttpServletRequest request,String r, HttpServletResponse response) {
        HttpSession session = request.getSession();

        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // 设置字体。
        gd.setFont(font);
        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        // 将四位数字的验证码保存到Session中。
        session.setAttribute("verifyCode", randomCode.toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        try {
            ServletOutputStream sos = response.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);
            sos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @GetMapping("/vip4/atm/g-bits/patch.zip")
    @ResponseBody
    public void patch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PathZip.patch(request,response);
    }


}
