package com.xian.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
@WebServlet("/code")
public class CheckCodeServlet extends HttpServlet {
    int wide = 100;
    int height = 50;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建一个对象，可以在内存中画图(验证码的图片对象)
        BufferedImage image = new BufferedImage(wide,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        Graphics g =image.getGraphics();//画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,wide,height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,wide-1,height-1);
        //2.3写验证码
        g.drawString("A37w",0,40);
        //3.将图片输出到展示页面
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
