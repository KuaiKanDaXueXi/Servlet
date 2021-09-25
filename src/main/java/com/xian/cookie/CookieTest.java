package com.xian.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 *在服务器中的Servlet是否有一个名为lastTime的cookie
 *
 * 1. 有：不是第一次访问
 * 	1. 欢迎回来，您上次访问的时间为：（显示时间字符串）
 * 	2. 写回Cookie：lastTime=2021-9-24-20:35
 * 2. 没有：是第一次访问
 * 	1. 响应数据：您好，欢迎您首次访问
 * 	2. 写回Cookie：lastTime=2021-9-24-20:35
 */

/**
 * @author xian
 * @date 2021/9/24 20:37
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取所有Cookie
        Cookie[] cookies = req.getCookies();
        //2.遍历cookie数组
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是：lastTime
                if ("lastTime".equals(name)){
                    //有：不是第一次访问
                    //欢迎回来，您上次访问的时间为：（显示时间字符串）
                    //  获取Cookie的value，时间
                    String value = cookie.getValue();
                    resp.getWriter().write("<h1>欢迎回来，您上次访问的时间为："+value+"</h1>");
                    //写回Cookie：lastTime=2021-9-24-20:35
                    break;
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
