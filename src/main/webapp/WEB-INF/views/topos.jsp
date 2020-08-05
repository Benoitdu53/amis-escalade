<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@include file="header.jsp"%>

    <body>

    <div class="idForm">
        <h3>Topos disponible(s)</h3>
    </div>

    <%--        On affiche tout les topos disponibles non possédés par l'utilisateur--%>

        <table id="topos">
            <tr>
                <th>Nom</th>
                <th>Description</th>
                <th>Lieu</th>
                <th>Date de création</th>
                <th>Propriétaire</th>
            </tr>

            <c:forEach var="toposDispo" items="${toposDispo}">
                        <tr>
                            <td><c:out value="${toposDispo.nom}"/></td>
                            <td><c:out value="${toposDispo.description}"/></td>
                            <td><c:out value="${toposDispo.lieu}"/></td>
                            <td><c:out value="${toposDispo.date}"/></td>
                            <td><c:out value="${toposDispo.utilisateur.pseudo}"/></td>
                            <td><a href="<c:url value="/reservationOn/${toposDispo.id}"/>"class="button2">Demande de réservation</a></td>
                        </tr>
                <br>
                </c:forEach>
        </table>

    </body>

<%@include file="footer.jsp"%>
