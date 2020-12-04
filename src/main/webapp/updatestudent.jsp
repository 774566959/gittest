<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "java.util.*,project.service.*,project.service.impl.*,project.pojo.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改学生</title>
</head>
<script type="text/javascript">
function viewImage(file){
    var preview = document.getElementById('preview');
    if(file.files && file.files[0]){
        preview.style.display = "block";
        preview.src = window.URL.createObjectURL(file.files[0]);
    }
    }
function $(elementId){
  return document.getElementById(elementId).value;
	}
function divId(elementId){
  return document.getElementById(elementId);
	}
function check(){
	var name=$("name");
	var divid=divId("name_prompt");
	var namereg=/\S+/;
	if(!namereg.test(name)){
		alert("请输入姓名!");
		event.preventDefault();
		return;
	}
	var score=$("score");
	var divid=divId("score_prompt");
	var scorereg=/^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/;	
	if(!scorereg.test(score)){
		alert("请输入0-100的数，且最多有两位小数！");
		event.preventDefault();
		return;
	}
	return true;
}
</script>
<body>
${updatemsg}
<h1>修改学生信息</h1>
<%
Student student = (Student)request.getAttribute("student");
%>
<form action="${pageContext.request.contextPath }/updstu" method="post" enctype="multipart/form-data">
学号：<input type="text" name="id" id="id" value="<%=student.getId() %>" readonly="readonly"><br>
姓名：<input type="text" name="name" id="name" value="<%=student.getName() %>"><br>
性别：
	<% if(student.getSex()==1){ %>  
	<input type='radio' name='sex' value='1' checked="checked">男
	<input type='radio' name='sex' value='0'>女<br>
	<% }else{ %>
	<input type='radio' name='sex' value='1'>男
	<input type='radio' name='sex' value='0' checked="checked">女<br>
	<% } %>
成绩：<input type="text" name="score" id="score" value="<%=student.getScore() %>"><br>
照片：<img id="preview" align="center" height="100px" width="100px" alt="" src="<%=student.getPhoto() %>">
<input type="file" name="file" id="file" onchange="viewImage(this)" /><br>
<input type="submit" value="修改" onclick="check()">
</form>
</body>
</html>