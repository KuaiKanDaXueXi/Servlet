package com.xian.servlet;

/**
 * @author Xian
 */

import sun.misc.Cache;

import javax.imageio.ImageIO;
import javax.naming.ldap.Control;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/code1")
public class CheckCodeDemo01 extends HttpServlet {
    //验证码如何实现的
    //前端实现
    //后端实现,需要用到java的图片类，生成一个图片

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 20;
        //如何让浏览器5s自动刷新一次
        //resp.setHeader("refresh","3");
        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics g = image.getGraphics();
        //设置图片的背景颜色
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        //给图片写数据
        g.setColor(Color.blue);
        g.setFont(new Font(null,Font.ITALIC,20));
        g.drawString(makeNumber(),0,20);
        //告诉浏览器这个请求用图片的形式打开
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
    private String makeNumber(){
        StringBuffer sb = new StringBuffer(new Random().nextInt(99999999));
        for (int i = 0; sb.length() < 8; i++) {
            sb.append(new Random().nextInt(9));
        }
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
