<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <%@ include file="header.jsp"%>
</head>

<body>

<!-- Informations du secteur séléctionner -->
<table border="1" id="tableauSite">
    <div class="titreSite">
        <caption>Secteur</caption>
        <tr>
            <th>id</th>
            <th>Nom</th>
            <th>Description</th>
        </tr>

        <tr>
            <td><c:out value="${secteur.id}"/></td>
            <td><c:out value="${secteur.nom}"/></td>
            <td><c:out value="${secteur.description}"/></td>
        </tr>
    </div>
</table>

<div class="ajoutVoie">
    <p><a href="<c:url value="/secteur/${secteur.id}/voie/add"/>">Ajouter une voie</a> </p>
</div>

<!-- Tableau des voies -->

<table border="1" id="tableauVoies">
    <div class="titreVoies">
        <caption>Voies</caption>
        <tr>
            <th>id</th>
            <th>Nom</th>
            <th>Taille</th>
        </tr>

        <c:forEach var="voies" items="${voies}">
            <tr>
                <td><c:out value="${voies.id}"/></td>
                <td><c:out value="${voies.nom}"/></td>
                <td><c:out value="${voies.taille}"/></td>
                <td><p><a href="<c:url value="/voie/${voies.id}/longueur"/>">Gestion de la longueur </a> </p></td>
                <td><a href="<c:url value="/voie/${voies.id}/delete"/>">Supprimer la voie</a></td>
            </tr>
        </c:forEach>

    </div>
</table>
</body>