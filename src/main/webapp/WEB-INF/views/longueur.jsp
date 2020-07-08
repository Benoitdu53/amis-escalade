<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <jsp:include page="header.jsp"></jsp:include><br>
</head>

<body>

<!-- Informations de la voie séléctionner -->
<table border="1" id="tableauVoie">
    <div class="titreVoie">
        <caption>Voie</caption>
        <tr>
            <th>id</th>
            <th>Nom</th>
            <th>Taille</th>
        </tr>

        <tr>
            <td><c:out value="${voie.id}"/></td>
            <td><c:out value="${voie.nom}"/></td>
            <td><c:out value="${voie.taille}"/></td>
        </tr>
    </div>
</table>

<div class="ajoutLongueur">
    <p><a href="<c:url value="/voie/${voie.id}/longueur/add"/>">Ajouter une longueur</a> </p>
</div>

<!-- Tableau des voies -->

<table border="1" id="tableauLongueur">
    <div class="titreLongueur">
        <caption>Longueurs</caption>
        <tr>
            <th>id</th>
            <th>Nombre de points</th>
            <th>Taille</th>
            <th>Cotation</th>
        </tr>

        <c:forEach var="longueurs" items="${longueurs}">
            <tr>
                <td><c:out value="${longueurs.id}"/></td>
                <td><c:out value="${longueurs.nbrePoints}"/></td>
                <td><c:out value="${longueurs.taille}"/></td>
                <td><c:out value="${longueurs.cotation}"/></td>
                <td><a href="<c:url value="/longueur/${longueurs.id}/delete"/>">Supprimer la longueur</a></td>
            </tr>
        </c:forEach>

    </div>
</table>
</body>