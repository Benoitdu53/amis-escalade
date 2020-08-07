    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <%@ include file="header.jsp"%>

<body>


<div class="idForm">
    <h3>Voies</h3>
</div>

<:c:if test="${not empty sessionScope.pseudo}">
    <div class="ajoutVoie">
        <p><a href="<c:url value="/secteur/${secteur.id}/voie/add"/>" class="button4">Ajouter une voie</a></p>
    </div>
</:c:if>
<!-- Tableau des voies -->

<table id="voies">
        <tr>
            <th>Nom</th>
            <th>Taille</th>
        </tr>

        <c:forEach var="voies" items="${voies}">
            <tr>
                <td><c:out value="${voies.nom}"/></td>
                <td><c:out value="${voies.taille}"/></td>
                <c:if test="${not empty sessionScope.pseudo}">
                    <td><p><a href="<c:url value="/voie/${voies.id}/longueur/add"/>" class="button2">Ajouter une longueur</a></td>
                    <td><a href="<c:url value="/voie/${voies.id}/delete"/>" class="button3">Supprimer la voie</a></td>
                </c:if>
            </tr>
        </c:forEach>
</table>

<%-- Tableau des longueurs--%>

<div class="idForm">
    <h3>Longueur(s)</h3>
</div>

<table id="longueurs">
    <tr>
        <th>Nom de la voie </th>
        <th>Nombre de point(s)</th>
        <th>Taille</th>
        <th>Cotation</th>
        <th>Ajouter par</th>
    </tr>

    <c:forEach var="longueurs" items="${longueurs}">
        <tr>
            <td><c:out value="${longueurs.voie.nom}"/></td>
            <td><c:out value="${longueurs.nbrePoints}"/></td>
            <td><c:out value="${longueurs.taille}"/></td>
            <td><c:out value="${longueurs.cotation}"/></td>
            <td><c:out value="${longueurs.utilisateur.pseudo}"/></td>
            <c:if test="${not empty sessionScope.pseudo}">
                <td><a href="<c:url value="/longueur/${longueurs.id}/delete"/>">Supprimer la longueur</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>

</body>

    <%@ include file="footer.jsp"%>