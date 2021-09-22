package com.xian.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Xian
 */
@WebServlet("/res2")
public class RequestDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //演示获取请求头数据
        //1.获取所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        //2.遍历
        while(headerNames.hasMoreElements()){
            //根据名称获取请求头的值
            String header = req.getHeader(headerNames.nextElement());
            System.out.println(header);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
