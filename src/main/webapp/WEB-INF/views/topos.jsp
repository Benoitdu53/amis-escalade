<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>

<html>
    <head>
        <title>Liste des topos</title>
        <%@include file="header.jsp"%>
    </head>

    <body>

<%--        On affiche tout les topos disponibles non possédés par l'utilisateur--%>

        <div class="allTopos">
        <table border="1" id="tableauTopos">
            <caption>Les topos dispos</caption>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Lieu</th>
                <th>Date</th>
                <th>Réserver</th>
            </tr>

            <c:forEach var="toposDispo" items="${toposDispo}">
<%--                <c:forEach var="toposDispo" items="${toposDispo}">--%>
                        <tr>
                            <td><c:out value="${toposDispo.id}"/></td>
                            <td><c:out value="${toposDispo.nom}"/></td>
                            <td><c:out value="${toposDispo.description}"/></td>
                            <td><c:out value="${toposDispo.lieu}"/></td>
                            <td><c:out value="${toposDispo.date}"/></td>
                            <td><c:out value="${empty toposDispo.isReserve ? 'Disponible' : ' Non disponible'}"/></td>
                            <td><c:if test="${reservationToposUtilisateur}"></c:if>
                                <a href="<c:url value="/reservationOn/${toposDispo.id}"/>">Demande de réservation</a>
                            </td>

                        </tr>
                </c:forEach>
<%--            </c:forEach>--%>
        </table>
        </div>

    </body>
</html>
