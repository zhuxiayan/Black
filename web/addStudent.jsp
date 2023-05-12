<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/12
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>

    <style>
        .titleDiv{
            height: 2px;
            color:white;
            padding-top: 12px;
            font-size: 50px;
            padding-left: 30px;
            font-family: 隶书;
        }

        .mainDiv{
            width: 899px;
            height: 500px;
            border: 4px rgb(237, 237, 237) solid;
            border-radius: 5px;
            background-image: url("https://cn.bing.com/images/search?view=detailV2&ccid=ZkoPhpKf&id=4929EB0212CFAC8CB6AB59DB53A9D2D99C54FF6A&thid=OIP.ZkoPhpKfJwsvGmpm8RsragHaFp&mediaurl=https%3a%2f%2fpic35.photophoto.cn%2f20150511%2f0034034892281415_b.jpg&exph=782&expw=1024&q=%e7%85%a7%e7%89%87%e9%a3%8e%e6%99%af%e5%9b%be%e7%89%87&simid=608049335316320088&FORM=IRPRST&ck=6F9ABFDBF15DF55715898BD2FE3E27BB&selectedIndex=0&idpp=overlayview&ajaxhist=0&ajaxserp=0");
            margin: auto;
            margin-top: 50px;
            background-size: auto;
        }

        .addDiv{
            height: 380px;
            width: 260px;
            padding:50px;
            background-color:rgba(255,255,255,0.9);
            border-radius:25px;
            border:1px #bdbdbd solid;
            opacity:0.9;
            float: right;
            margin-right: 80px
        }

        .name{
            font-size: 20px;

        }

        .item{
            height:60px;
        }

        .item input{
            line-height:40px;
            width:245px;
            border:none;
            border-bottom: 1px solid #59c2c5;
            margin-bottom: 20px;
            margin-top: 10px;
        }

        .btn{
            display:block;
            width:255px;
            height:50px;
            color:#fff;
            background:#59c2c5;
            font-size:16px;
            line-height:30px;
            text-align:center;
            border-radius:10px;
            border:none;
            margin-top: 10px;
        }

        a{
            font-size:18px;
            padding-left:200px;
            padding-bottom: 50px;
            color:#59c2c5;

        }

    </style>
</head>

<body>
<div class="mainDiv">
    <div class="titleDiv">学生信息管理平台</div>
    <form action = "AddServlet">
        <div class = "addDiv">
            <div class = "name">添加学生信息</div>

            <div class = "item">
                <input type = "text" name="sno" placeholder="学号"/>
            </div>
            <div class = "item">
                <input type = "text" name="sname" placeholder="姓名"/>
            </div>
            <div class = "item">
                <input type = "text" name="sex" placeholder="性别"/>
            </div>
            <div class = "item">
                <input type = "text" name="age" placeholder="年龄"/>
            </div>
            <div class = "item">
                <input type = "text" name="phone" placeholder="电话"/>
            </div>
            <input type = "submit" class = "btn" value = "添加"/>
            <a href = "main.jsp">返回</a>
        </div>
    </form>
</div>
</div>
</body>
</html>