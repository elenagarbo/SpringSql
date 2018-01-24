<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Restaurante Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	
	 <meta charset="utf-8">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	 
</head>
<body>
<h1>
	Añadir a Restaurante
</h1>

<c:url var="addAction" value="/restaurante/add" ></c:url>

<form:form action="${addAction}" commandName="restaurante">
<table>
	<c:if test="${!empty restaurante.nombre}">
	
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="id"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	
	<tr>
		<td>
			<form:label path="nombre">
				<spring:message text="Nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombre" />
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="direccion">
				<spring:message text="Direccion"/>
			</form:label>
		</td>
		<td>
			<form:input path="direccion" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="tipo">
				<spring:message text="Tipo"/>
			</form:label>
		</td>
		<td>
			<form:input path="tipo" />
		</td>
	</tr>
	
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty restaurante.nombre}">
				<input type="submit"
					value="<spring:message text="Editar Restaurante" />" class="btn btn-danger" />
			</c:if>
			<c:if test="${empty restaurante.nombre}">
				<input type="submit"
					value="<spring:message text="Añadir Restaurante" />" class="btn btn-danger" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Restaurantes List</h3>
<c:if test="${!empty listRestaurantes}">
	<table class="tg">
	<tr>
		<th width="80">Restaurante ID</th>
		<th width="120">Restaurante Nombre</th>
		<th width="120">Restaurante Direccion</th>
		<th width="60">Restaurante Tipo</th>
	
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listRestaurantes}" var="restaurante">
		<tr>
			<td>${restaurante.id}</td>
			<td>${restaurante.nombre}</td>
			<td>${restaurante.direccion}</td>
			<td>${restaurante.tipo}</td>
			
			<td><a href="<c:url value='/edit/${restaurante.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${restaurante.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</body>
</html>
