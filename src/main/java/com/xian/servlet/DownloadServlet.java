package com.xian.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Xian
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        //使用字节输入流加载文件进内存
        //找到文件的服务器路径
        ServletContext context = req.getServletContext();
        String path = context.getRealPath("/image/"+filename);
        //用字节流关联
        FileInputStream fis = new FileInputStream(path);
        //设置response响应头
        //1.设置响应头：
        String type = context.getMimeType(filename);
        resp.setContentType(type);
        //2.设置响应头打开方式：
        resp.setHeader("content-disposition","attachment;filename="+filename);
        //将输入流的数据写入到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = (fis.read(buff))) != -1){
            sos.write(buff,0,len);
        }

        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
