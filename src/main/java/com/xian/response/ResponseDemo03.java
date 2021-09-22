package com.xian.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Xian
 */
@WebServlet("/resp3")
public class ResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //统一编解码字符集
        //resp.setCharacterEncoding("GBK");(使用下面的方法可以不写这个)
        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用给编码解码
        //resp.setHeader("content-type","text/html;charset=utf-8");
        //简单的形式
        resp.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter out = resp.getWriter();
        //2.输出数据
        out.write("<h1>hello 你好</h1>");
    }
}
