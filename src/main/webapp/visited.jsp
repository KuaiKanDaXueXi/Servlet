<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Xian
  Date: 2021/9/24
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String firstTime = (String) request.getAttribute("firstTime");
    if ("true".equals(firstTime)) {
        out.println("<h1>你好，欢迎您首次访问。</h1>");
    } else {
        out.println("<h1>欢迎回来，您上次访问的时间为："+ URLDecoder.decode(request.getAttribute("lastTime")+"") +"</h1>");
    }
%>
</body>
</html>
