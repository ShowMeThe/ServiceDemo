<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/8
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
%>
<html>
  <head>
    <title>信息管理系统</title>
  </head>
   <style type="text/css" >
    body{
        background-image: url("http://localhost:8081/pic/web_bg3.png");
        background-size: auto;
    }
       div{
           margin: 250px auto;
           height: 250px;
           width: 250px;
       }
       label{
              color: cornflowerblue;
       }
       input{
           text-decoration-color: cornflowerblue;
           border: 1px solid #ccc;
           border-radius: 3px;
           padding: 7px 5px 7px 5px;
       }
   </style>
    <body>
    <form action="LoginService" method="post">
        <div >
            <label>
                <h4>用户名：</h4><br>
                <input type="text" name="username" value=""/>
                <h4>密  码：</h4><br>
                <input type="text" name="password" />
                <br> <br><input  type="submit" value="登录"/>
            </label>
        </div>
    </form>
    </body>
</html>
