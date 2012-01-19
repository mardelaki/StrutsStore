<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project4 -Basket using Struts2</title>
</head>
<body>
	<div align="center">
		<h3>This is Project 4 implemented using Struts2</h3>
		<h4>Please select:</h4>
		<s:form action="Store.action" method="post">
			<s:submit method="populate" align="center" title="See your Basket"  value="See your Basket"/>
		</s:form>
		<form method="get" action="Redirector.do">
			<input type="Submit" value="Info">
		</form>
		<form method="get" action="GetCode.do">
			<input type="Submit" value="Code">
		</form>

	</div>

</body>
</html>