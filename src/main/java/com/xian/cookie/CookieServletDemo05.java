package com.xian.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xian
 * @date 2021/9/24 18:28
 */
@WebServlet("/cookie5")
public class CookieServletDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean ret = true;
        Cookie[] cookies = req.getCookies();
        String lastTime = "";
        String time = URLEncoder.encode(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(System.currentTimeMillis())));
        for (Cookie cookie : cookies) {
            if ("lastTime".equals(cookie.getName())) {
                lastTime = cookie.getValue();
                cookie.setValue(time);
                cookie.setMaxAge(60 * 60);
                resp.addCookie(cookie);
                ret = false;
                break;
            }
        }
        if (ret) {
            req.setAttribute("firstTime","true");
            resp.addCookie(new Cookie("lastTime",time));
        } else {
            req.setAttribute("lastTime",lastTime);
        }
        req.getRequestDispatcher("/visited.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
