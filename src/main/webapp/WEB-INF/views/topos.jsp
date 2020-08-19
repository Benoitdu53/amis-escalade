<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="idForm">
            <h3>Topos disponible(s)</h3>
        </div>
    </div>

    <div class="clear"></div>

    <body>
    <div class="row justify-content-center">
        <%--        On affiche tout les topos disponibles non possédés par l'utilisateur--%>
        <div class="col">
            <table class="topos">
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Lieu</th>
                    <th>Date de création</th>
                </tr>

                <c:forEach var="toposDispo" items="${toposDispo}">
                    <tr>
                        <td><c:out value="${toposDispo.nom}"/></td>
                        <td><c:out value="${toposDispo.description}"/></td>
                        <td><c:out value="${toposDispo.lieu}"/></td>
                        <td><c:out value="${toposDispo.date}"/></td>
                        <td><a href="<c:url value="/reservationOn/${toposDispo.id}"/>">Demande de
                            réservation</a></td>
                    </tr>
                    <br>
                </c:forEach>
            </table>
        </div>
    </div>
    </body>
</div>

<%@include file="footer.jsp" %>
