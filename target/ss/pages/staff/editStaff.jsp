<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<script>
	function onDeptSelected(value) {
		var data = new FormData();
		data.append("deptId", value);

		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr.addEventListener("readystatechange", function () {
			if (this.readyState === 4) {
				console.log(this.responseText);
				//对请求回来的数据进行解析
				json=eval('('+this.responseText+')');
				//获取服务器的标签
				serverSelect=document.getElementById("postselected");
				//获取option标签
				optionEle=serverSelect.getElementsByTagName("option");
				//获取option的数量
				length=optionEle.length;
				//使用循环清空所有的option标签
				for(var i=0;i<length;i++){
					serverSelect.removeChild(optionEle[0]);
				}

				//将json数据插入到option中
				for (var i=0;i<json.length;i++){
					//创建option标签
					option=document.createElement("option");
					//设置value属性
					option.setAttribute("value",json[i].postId);
					//设置文本信息
					text=document.createTextNode(json[i].postName);
					//把文本信息添加到option中
					option.appendChild(text);
					//把option标签添加到servers的select中
					serverSelect.appendChild(option);
				}
			}
		});

		xhr.open("POST", "http://localhost:8080/staff/getPosts");

		xhr.send(data);
	}

</script>
<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>



<form action="/staff/saveStaff.action" method="post">
	
	<input type="hidden" name="staffId" value="${staffId}"/>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">

		<%
			if (request.getParameter("staffName") != null){
				String newStaffName = new String(request.getParameter("staffName").getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("editStaffNameJsp",newStaffName);
				String newonDutyDate=new String(request.getParameter("onDutyDate").getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("editStaffDateJsp",newonDutyDate);
				String newGender=new String(request.getParameter("gender").getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("editStaffGenderJsp",newGender);
				String newloginName=new String(request.getParameter("loginName").getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("editStaffloginNameJsp",newloginName);
				String newloginPwd=new String(request.getParameter("loginPwd").getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("editStaffloginPwdJsp",newloginPwd);
				String newpostName=new String(request.getParameter("post.postName").getBytes("iso-8859-1"),"utf-8");
				request.setAttribute("editStaffpostNameJsp",newpostName);

			}
		%>
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="${editStaffloginNameJsp}" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value="${editStaffloginPwdJsp}" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="${editStaffNameJsp}" /> </td>
	    <td>性别：</td>
	    <td>
			<c:if test="${editStaffGenderJsp == '男'}">
				<input type="radio" name="gender" checked="checked" value="男"/>男
				<input type="radio" name="gender" value="女"/>女
			</c:if>
			<c:if test="${editStaffGenderJsp == '女'}">
				<input type="radio" name="gender" value="男"/>男
				<input type="radio" name="gender" checked="checked" value="女"/>女
			</c:if>
	    </td>
	  </tr>
	 <tr>
		 <td width="10%">所属部门：</td>
		 <td width="20%">
			 <select id="deptId" name="post.dept.deptId" onchange="onDeptSelected(value)">
				 <option value="-1">----请--选--择----</option>
				 <s:iterator value="departmentList" var="d">
					 <s:if test="#d.deptId==post.dept.deptId">
						 <option value="${d.deptId}" selected="selected">${d.deptName}</option>
					 </s:if>

					 <s:else>
						 <option value="${d.deptId}">${d.deptName}</option>
					 </s:else>
				 </s:iterator>
			 </select>

		 </td>
		 <td width="8%">职务：</td>
		 <td width="62%">
			 <select id="postselected" name="post.postId">
				 <option value="${post.postId}">${editStaffpostNameJsp}</option>
			 </select>
		 </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="${editStaffDateJsp}" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>

</body>
</html>
