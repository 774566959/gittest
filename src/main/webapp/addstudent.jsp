<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生</title>
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
	var id=$("id");
	var divid=divId("id_prompt");
	var idreg=/^[0-9]*[1-9][0-9]*$/;	
	if(!idreg.test(id)){
		alert("请输入正整数作为学号!");
		event.preventDefault();
		return;
	}
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
    var file = document.getElementById("photo").value;
    if(file.length==0||file==""){
        alert("请选择上传文件");
        return false;
    }
	return true;
}
</script>
<body>
${addmsg}
<h1>添加学生信息</h1>
<form action="${pageContext.request.contextPath }/addstu" method="post" enctype="multipart/form-data" onsubmit="return check()">
学号：<input type="text" name="id" id="id"><br>
姓名：<input type="text" name="name" id="name"><br>
性别：<input type='radio' name='sex' value='1' checked="checked">男
	<input type='radio' name='sex' value='0'>女<br>
成绩：<input type="text" name="score" id="score"><br>
照片：<input type="file" name="file" id="file" onchange="viewImage(this)" />
<img height="100px" width="100px" id="preview" src="" alt=""  style="width: 100px;height: 100px;" style="diplay:none"><br>
<input type="submit" value="添加">
</form>
</body>
</html>