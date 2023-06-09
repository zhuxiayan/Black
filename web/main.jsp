<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/12
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>学生信息管理平台</title>

    <style>
        .titleDiv{
            height: 85px;
            color:white;
            padding-top: 30px;
            font-size: 50px;
            padding-left: 30px;
            font-family: 隶书;
        }

        .mainDiv{
            width: 899px;
            height: 500px;
            border: 4px rgb(237, 237, 237) solid;
            border-radius: 5px;
            background-image: url("https://img1.baidu.com/it/u=4271373647,1745018175&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500");
            margin: auto;
            margin-top: 50px;
            background-size: auto;
        }

        .Navigation{
            width: 899px;
            height: 200px;
            background-color:#59c2c5;
            opacity:0.8;
            text-align: center;
            line-height: 200px;
            font-family: 楷体;

        }

        a{
            font-size:30px;
            color:whitesmoke;
            padding-left:20px;
            text-decoration: none;
        }

        a:hover{
            color: blue;
            font-family: 隶书;
        }

    </style>
</head>
<body>
<div class="mainDiv">
    <div class="titleDiv">欢迎进入学生信息管理平台</div>
    <%
        if(session.getAttribute("login") == null) {
            session.setAttribute("loginErrorMessage", "您必须先登录才能访问主页！");
            response.sendRedirect("index.jsp");
        }
    %>
    <div class="Navigation">
        <a href="addStudent.jsp">添加学生</a>
        <a href="ShowStudentsByPageServlet">分页查询</a>
        <a href="ShowAllStudentsServlet">查看所有学生信息</a>
        <a href="QuitServlet">退出登录</a>
    </div>
</div>
</body>
</html>
