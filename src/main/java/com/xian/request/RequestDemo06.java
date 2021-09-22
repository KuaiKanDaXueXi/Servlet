package com.xian.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author Xian
 */
@WebServlet("/res6")
public class RequestDemo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String[] hobbies = req.getParameterValues("hobby");
        /*for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/
        //获取所有的参数名
        Enumeration<String> parameterNames = req.getParameterNames();
        /*while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }*/
        Map<String, String[]> map = req.getParameterMap();
        Set<String> key = map.keySet();
        for (String s : key) {
            for (String s1 : map.get(s)) {
                System.out.println(s1);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
