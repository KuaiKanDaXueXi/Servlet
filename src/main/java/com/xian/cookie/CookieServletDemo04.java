package com.xian.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author xian
 * @date 2021/9/23 21:27
 */
@WebServlet("/cookie4")
public class CookieServletDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg", "你好");
        //URLEncoder.encode("你好")       中文转码：解决乱码问题
        //3.发送Cookie
        resp.addCookie(cookie);
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie1 : cookies) {
            System.out.println(cookie1.getName());
            System.out.println(cookie1.getValue());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
