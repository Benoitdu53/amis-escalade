<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <jsp:include page="include/header.jsp"></jsp:include><br>
</head>

<body>

<!-- Informations du secteur séléctionner -->
<table border="1" id="tableauSite">
    <div class="titreSite">
        <caption>Secteur</caption>
        <tr>
            <th>id</th>
            <th>secteur</th>
            <th>Nombre de voies</th>
        </tr>

        <tr>
            <td><c:out value="${secteur.id}"/></td>
            <td><c:out value="${secteur.secteur}"/></td>
            <td><c:out value="${secteur.nbreVoie}"/></td>
        </tr>
    </div>
</table>

<div class="ajoutVoie">
    <p><a href="<c:url value="/secteur/${secteur.id}/voie/add"/>">Ajouter une voie</a> </p>
</div>

<!-- Tableau des voies -->

<table border="1" id="tableaVvoies">
    <div class="titreVoies">
        <caption>Voies</caption>
        <tr>
            <th>id</th>
            <th>Voie</th>
            <th>Longueur</th>
            <th>Cotation</th>
        </tr>

        <c:forEach var="voies" items="${voies}">
            <tr>
                <td><c:out value="${voies.id}"/></td>
                <td><c:out value="${voies.voie}"/></td>
                <td><c:out value="${voies.longueur}"/></td>
                <td><c:out value="${voies.cotation}"/></td>
                <td><p><a href="<c:url value="/voie/${voies.id}/longueur"/>">Gestion de la longueur </a> </p></td>
                <td><a href="<c:url value="/voie/${voies.id}/delete"/>">Supprimer la voie</a></td>
            </tr>
        </c:forEach>

    </div>
</table>
</body>