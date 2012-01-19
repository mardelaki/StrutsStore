<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
<head>

<title>Struts 2 - eStore Application</title>
</head>

<body>

	<s:actionerror />

	<center>
		<h1>This is your Basket</h1>
	</center>
	<s:form action="Store.action" method="post">
		<table border=0 align="center">

			<tr>
				<td bgcolor="#E3CEF6" colspan="2"><strong>Cafe</strong></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><%=application.getInitParameter("Cafe")%></td>
			</tr>

			<s:textfield name="Qcafe" value="%{Qcafe}" label="Quantity" />

			<td>Total :</td>
			<td><s:property value="coffeeTotal" />
			<td>
			<tr></tr>
			<tr>
				<td bgcolor="#E3CEF6" colspan="2"><strong>Sugar</strong></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><%=application.getInitParameter("Sugar")%></td>
			</tr>
			<s:textfield name="Qsugar" value="%{Qsugar}" label="Quantity" />
			<td>Total :</td>
			<td><s:property value="sugarTotal" /></td>
			<tr></tr>
			<tr>
				<td bgcolor="#E3CEF6" colspan="2"><strong>Water</td>
				</strong>
			</tr>
			<tr>
				<td>Price:</td>
				<td><%=application.getInitParameter("Water")%></td>
			</tr>
			<s:textfield name="Qwater" value="%{Qwater}" label="Quantity" />
			<td>Total :</td>
			<td><s:property value="waterTotal" /></td>

			<tr>

				<td bgcolor="#E3CEF6" colspan="1"><strong>Total:</strong></td>
				<td bgcolor="#E3CEF6" colspan="1"><strong><s:property
							value="total" /></strong></td>

			</tr>
		</table>
		</br>
		</br>
		<div align="center">
			<s:submit method="execute" align="center" />
		</div>
	</s:form>
	<div align="center">
		<form method="get" action="Redirector.do">
			<input type="Submit" value="Info">
		</form>
		<form method="get" action="GetCode.do">
			<input type="Submit" value="Code">
		</form>
	</div>
</body>
</html>
