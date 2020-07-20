<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <%@ include file="header.jsp" %>
    </head>

    <body>
<%--        On affiche la liste des topos possédé par l'utilisateur--%>

<div class="navbarSites">
    <p><a href="<c:url value="/formTopos"></c:url>">Enregistrer un topo</a></p>
</div>

<table border="1" id="tableauTopos">
    <caption>Site</caption>
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Description</th>
        <th>Lieu</th>
        <th>Réserver</th>
        <th>Date</th>
    </tr>

    <c:forEach var="topos" items="${topos}">
        <tr>
            <td><c:out value="${topos.id}"/></td>
            <td><c:out value="${topos.nom}"/></td>
            <td><c:out value="${topos.description}"/></td>
            <td><c:out value="${topos.lieu}"/></td>
            <td><c:out value="${topos.isReserve}"/></td>
            <td><c:out value="${topos.date}"/></td>
        </tr>
    </c:forEach>

</table>
<%--        On affiche ces demandes en cours ( mes demandes reçus, mes demandes envoyés, mes topos loués )--%>

<%--        On affiche tout les topos disponibles non possédés par l'utilisateur--%>
    </body>
</html>
