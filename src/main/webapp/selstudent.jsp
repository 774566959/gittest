<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "java.util.*,project.service.*,project.service.impl.*,project.pojo.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询学生</title>
</head>
<script type="text/javascript">
function $(elementId){
  return document.getElementById(elementId).value;
	}
function divId(elementId){
  return document.getElementById(elementId);
	}
function check(){
	var id=$("id");
	var divid=divId("id_prompt");
	var idreg=/^[0-9]*[1-9][0-9]*$/;	
	if(!idreg.test(id)){
		alert("请输入正整数学号!");
		event.preventDefault();
		return;
	}
}
</script>
<body>
<h1>按学号查询学生</h1>
<form action="${pageContext.request.contextPath }/getstu" method="post">
请输入要查询的学生学号：
<input type="text" name="id" id="id">
<input type="submit" value="查询" onclick="check()">
</form>
<%
	if(request.getAttribute("student")!=null){
		Student student = (Student)request.getAttribute("student");
		out.print("<h3>查找到的学生信息如下</h3>");
		out.print("学号："+student.getId()+"<br>");
		out.print("姓名："+student.getName()+"<br>");
		if(student.getSex()==1)
		out.print("性别：男<br>");
		else
		out.print("性别：女<br>");
		out.print("成绩："+student.getScore()+"<br>");
		out.print("照片："+"<img height='100px' width='100px' alt='' src='"+student.getPhoto()+"'><br>");
	}
	else
		out.print("查无此人");
%>
</body>
</html>