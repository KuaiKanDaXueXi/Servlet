package com.xian.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Xian
 */
@WebServlet("/scd5")
public class ServletContextDemo05 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext功能
        //1. 获取MIME类型
        //2. 域对象：共享数据的
        //3. 获取文件的真实（服务器路径）路径
        //通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //获取文件的服务器路径
        String path = context.getRealPath("/WEB-INF/web.xml");//web目录下资源的访问
        System.out.println(path);
        File file = new File(path);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}