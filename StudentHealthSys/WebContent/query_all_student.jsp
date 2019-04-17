<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*" %>
 <%@page import="configUtil.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有学生信息</title>
</head>
<body style="padding-left:100px;padding-top:20px">
 <%!
   List<StudentHealthJavaBean> list=null;
   StudentHealthJavaBean student=null;
 %> 
 <table border="2">
 <tr><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>身高/厘米</td><td>体重/斤</td></tr>
 <%
    list=(List<StudentHealthJavaBean>)request.getAttribute("list");
    for(int i=0;i<list.size();i++){
    	student=list.get(i);
  %>
    <tr>
    <td><%=student.getId()%></td>
    <td><%=student.getName()%></td>
    <td><%=student.getSex()%></td>
    <td><%=student.getAge()%></td>
    <td><%=student.getHight()%></td>
    <td><%=student.getWeight()%></td>
    </tr> 
   <% 
    }
   %>
 </table>
</body>
</html>