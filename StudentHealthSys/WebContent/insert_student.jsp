<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="configUtil.StudentHealthJavaBean" %>
<%@page import="servlet.Servlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.inputfront{font-size: 18px;margin-left:10px;}
.p1{margin-left:260px;}
</style>
</head>
<body>

<br>

<form method="post" action="servlet.Servlet">
<table class="p1">
<tr><td>学生学号 :</td><td><input type="text" name="id" class="inputfront"/></td></tr>
<tr><td>姓名 :</td><td><input type="text" name="name" class="inputfront"/></td></tr>
<tr><td>性别 :</td><td><input type="text" name="sex" class="inputfront"/></td></tr>
<tr><td>年龄 :</td><td><input type="text" name="age" class="inputfront"/></td></tr>
<tr><td>身高/厘米 :</td><td><input type="text" name="hight" class="inputfront"/></td></tr>
<tr><td>体重/斤 :</td><td><input type="text" name="weight" class="inputfront"/></td></tr>
</table>

<input type="hidden" name="methor" value="insert"/>
<input type="submit" name="submit" value="提交" style="margin-left:400px;margin-top:18px;font-size:20px;"/>
</form>

</body>
</html>