<%@ page contentType="text/html;charset=UTF-8" %>

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <%@ include file="header.jsp"%>

<body>

<%--Si utilisateur connecté affiché "Ajouter une voie"--%>
<c:if test="${not empty sessionScope.pseudo}">
    <div class="ajoutVoie">
        <p><a href="<c:url value="/secteur/${secteur.id}/voie/add"/>" class="button2">Ajouter une voie</a></p>
    </div>
</c:if>

<div class="idForm">
    <h3>Voies</h3>
</div>

<br>

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
                <td><a href="<c:url value="/voie/${voies.id}/longueur"/>"class="button2">Voir la voie</a></td>
                <c:if test="${not empty sessionScope.pseudo}">
                    <td><a href="<c:url value="/voie/${voies.id}/delete"/>" class="button3">Supprimer la voie</a></td>
                </c:if>
            </tr>
        </c:forEach>
</table>

</body>

    <%@ include file="footer.jsp"%>