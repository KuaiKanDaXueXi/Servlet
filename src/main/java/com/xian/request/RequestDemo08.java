package com.xian.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xian
 */
@WebServlet("/res8")
public class RequestDemo08 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo8 has been visited...");
        //存储数据到request域中
        req.setAttribute("name","zhangsan");
        //转发到demo9资源
        req.getRequestDispatcher("/res9").forward(req,resp);
        //req.getRequestDispatcher("https://www.baidu.com").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
