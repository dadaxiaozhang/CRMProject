<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

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
					serverSelect.innerHTML = "<option value = ''>--请选择--</option>";
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

		function condition(){
			var data = new FormData();
			data.append()
		}
	</script>

		<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="${pageContext.request.contextPath}/staff/addStaff.action">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<form  action="/staff/findStaffByCondition.action" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">

			<select name="post.dept.deptId" onchange="onDeptSelected(value)">
				<option value="">----请--选--择----</option>
				<s:iterator value="departmentList" var="department">
					<s:if test="#department.deptId==model.dept.deptId">
						<option value="${department.deptId}" selected="selected">${department.deptName}</option>
					</s:if>

					<s:else>
						<option value="${department.deptId}">${department.deptName}</option>
					</s:else>
				</s:iterator>
			</select>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >

			<select id="postselected" name="post.postId">
				<option value="">----请--选--择----</option>
			</select>
	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>

	<s:iterator value="staffList" var="staff">

	<tr class="<s:property value="#sl.even ? 'tabtd2':'table1'" />">
		<td align="center">${staff.staffName}</td>
		<td align="center">${staff.gender}</td>
		<td align="center">${staff.onDutyDate}</td>
		<td align="center">${post.dept.deptName}</td>
		<td align="center">${post.postName}</td>

		<td width="7%" align="center">
			<s:a action="findAllStaff">
				<s:param name="staffId" value="staffId"/>
				<%--private int staffId;--%>
				<%--private String loginName,loginPwd,staffName,gender,onDutyDate;--%>
				<%--private Post post;--%>

				<a href="/staff/updateStaff.action?post.postName=${post.postName}&staffId=${staff.staffId}&post.postId=${post.postId}&post.dept.deptId=${post.dept.deptId}&loginPwd=${staff.loginPwd}&loginName=${staff.loginName}&staffName=${staff.staffName}&gender=${staff.gender}&onDutyDate=${staff.onDutyDate}">
				<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
			</s:a>
		</td>
		</s:iterator>
  
    

</table>



<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>

</body>
</html>
