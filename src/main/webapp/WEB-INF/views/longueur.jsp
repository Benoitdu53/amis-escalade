<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<body>

<%--Si utilisateur connecté affiché "Ajouter une voie"--%>
<c:if test="${not empty sessionScope.pseudo}">
    <div class="ajoutLongueur">
        <p><a href="<c:url value="/voie/${voies.id}/longueur/add"/>" class="button2">Ajouter une longueur</a></p>
    </div>
</c:if>

<br>

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
            <c:if test="${not empty sessionScope.utilisateur}">
                <td><a href="<c:url value="/longueur/${longueurs.id}/delete"/>">Supprimer la longueur</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>

</body>

<%@ include file="footer.jsp"%>