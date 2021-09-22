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
@WebServlet("/res3")
public class RequestDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        //演示获取请求头数据：user-agent
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("Chrome browser...");
        } else if (agent.contains("Firefox")) {
            System.out.println("Firefox browser...");
        } else {
            System.out.println("Others browser...");
        }*/
        //演示获取请求头数据：referer
        String referer = req.getHeader("referer");
        if (referer != null) {
            if (referer.contains("localhost:8080")) {
                System.out.println("正常访问");
            } else{
                System.out.println("无权访问");
            }
        }else{
            System.out.println("无权访问");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
