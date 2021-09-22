package com.xian.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Xian
 */
@WebServlet("/res4")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求消息体---请求参数
        //1.获取字符流
        BufferedReader br = req.getReader();
        //2.读取数据
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
}
