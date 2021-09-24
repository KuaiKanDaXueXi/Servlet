package com.xian.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author xian
 * @date 2021/9/23 21:27
 */
@WebServlet("/cookie3")
public class CookieServletDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg", "setMaxAge");
        //2.设置Cookie的存活时间
        cookie.setMaxAge(40);//表示：将cookie持久化到硬盘，持久化30秒自动删除cookie
        //cookie.setMaxAge(-1);
        //cookie.setMaxAge(0);
        //3.发送Cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
