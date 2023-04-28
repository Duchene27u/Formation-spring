<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des clients</h1>
<ul>
<c:forEach items="${pageDeClients.content}" var="client">
	<li>${client.nom} ${client.prenom} ${client.pays.nom} ${client.dateHeureInscription}</li>
</c:forEach>
</ul>
<c:if test="${!pageDeClients.isFirst()}">
<a href="clients?page=0&sort=${sort}">&#x23EE;</a>
<a href="clients?page=${pageDeClients.number-1}&sort=${sort}">&#x23EA;</a>
</c:if>
Page ${pageDeClients.getNumber()+1}
<c:if test="${!pageDeClients.last}">
<a href="clients?page=${pageDeClients.number+1}&sort=${sort}">&#x23E9;</a>
<a href="clients?page=${pageDeClients.totalPages - 1}&sort=${sort}">&#x23ED;</a>
</c:if>
<br><br>
Client de ${pageDeClients.totalElements == 0 ? 0 : pageDeClients.size * pageDeClients.number+1} à ${pageDeClients.numberOfElements + (pageDeClients.size * pageDeClients.number)} sur ${pageDeClients.getTotalElements()} Clients
<br><br>
<a href="clients?page=0&sort=dateHeureInscription,DESC">Trier sur date heure inscription décroissante</a><br>
<a href="/swagger-ui/index.html#/" target="swagger">Swagger</a><br>
<a href="/h2-console" target="h2_console">Console H2</a>
<jsp:useBean id="dateFin" class="java.util.Date"/>
<c:set var="msFin" value="${dateFin.getTime()}" scope="page" />
<p>Page générée en ${msFin - msDepart} ms</p>
</body>
</html>
