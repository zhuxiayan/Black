<%@ page import="po.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/12
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理平台</title>

    <style>
        .mainDiv{
            width: 900px;
            height: 700px;
            border: 4px rgb(237, 237, 237) solid;
            border-radius: 5px;
            background-image:url("https://cn.bing.com/images/search?view=detailV2&ccid=ZkoPhpKf&id=4929EB0212CFAC8CB6AB59DB53A9D2D99C54FF6A&thid=OIP.ZkoPhpKfJwsvGmpm8RsragHaFp&mediaurl=https%3a%2f%2fpic35.photophoto.cn%2f20150511%2f0034034892281415_b.jpg&exph=782&expw=1024&q=%e7%85%a7%e7%89%87%e9%a3%8e%e6%99%af%e5%9b%be%e7%89%87&simid=608049335316320088&FORM=IRPRST&ck=6F9ABFDBF15DF55715898BD2FE3E27BB&selectedIndex=0&idpp=overlayview&ajaxhist=0&ajaxserp=0");
            margin: auto;
            background-size: auto;
        }

        .titleDiv{
            height: 20px;
            color:white;
            padding-top: 30px;
            font-size: 50px;
            padding-left: 30px;
            font-family: 隶书;
        }

        .showStudentDiv{
            background-size: cover;
            width:700px;
            height:500px;
            margin: auto;
            margin-top: 50px;

        }

        .item{
            height:40px;
            border-radius:15px;
        }

        .item a{
            background-color: lightgrey;
            text-decoration: none;
            font-size:15px;
            color:black;
            border-radius:3px;
        }


        table{
            width:100%;
            border-collapse:collapse;
            background-color: rgba(255,255,255,0.9);
            opacity: 0.8;
        }


        table body{
            display: block;
            height:300px;
            overflow-y: scroll;
        }
        table td{
            border:1px solid #A6A6A6;
            height:30px;
            width: 300px;
            text-align: center;
            font-size: 15px;
        }
        table th{
            height:30px;
            border:1px solid #A6A6A6;
        }



    </style>
</head>
<body>
<div class="mainDiv">
    <div class="titleDiv">查看所有学生信息</div>
    <div class = "showStudentDiv">
        <table  border="2" cellspacing="0">
            <tr>
                <th><h3>学号</h3></th>
                <th><h3>姓名</h3></th>
                <th><h3>性别</h3></th>
                <th><h3>年龄</h3></th>
                <th><h3>电话</h3></th>
                <th><h3>操作</h3></th>
            </tr>
            <%

                List<Student> allStudents = (List<Student>)session.getAttribute("allStudents");
                for (int i = 0; i < allStudents.size(); i++) {
                    Student s  = allStudents.get(i);
            %>
            <tr>
                <td><%=s.getSno() %></td>
                <td><%=s.getSname() %></td>
                <td><%=s.getSex() %></td>
                <td><%=s.getAge() %></td>
                <td><%=s.getPhone() %></td>
                <td>
                    <a href = "DeleteServlet?sno=<%=s.getSno() %>">删除</a>
                    <a href = "QueryStudentBySnoServlet?sno=<%=s.getSno()%>">修改</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <a href = "main.jsp">返回</a>
    </div>

</div>
</body>
</html>