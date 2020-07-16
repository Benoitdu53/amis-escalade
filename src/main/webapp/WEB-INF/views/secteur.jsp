<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <%@ include file="header.jsp"%>
</head>

<body>

    <!-- Informations du site séléctionner -->
    <table border="1" id="tableauSite">
        <div class="titreSite">
            <caption>Site</caption>
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>Departement</th>
                <th>Pays</th>
                <th>Type</th>
                <th>Cotation-min</th>
                <th>Cotation-max</th>
                <th>Description</th>
            </tr>

            <tr>
                <td><c:out value="${site.id}"/></td>
                <td><c:out value="${site.nom}"/></td>
                <td><c:out value="${site.departement}"/></td>
                <td><c:out value="${site.pays}"/></td>
                <td><c:out value="${site.type}"/></td>
                <td><c:out value="${site.cotationMin}"/></td>
                <td><c:out value="${site.cotationMax}"/></td>
                <td><c:out value="${site.description}"/></td>
            </tr>
        </div>
</table>

    <div class="ajoutSecteur">
        <p><a href="<c:url value="/site/${site.id}/secteur/add"/>">Ajouter un secteur</a> </p>
    </div>

    <!-- Tableau des secteurs -->

    <table border="1" id="tableauSecteurs">
        <div class="titreSecteur">
            <caption>Secteurs</caption>
            <tr>
                <th>id</th>
                <th>Nom</th>
                <th>Description</th>
            </tr>

            <c:forEach var="secteurs" items="${secteurs}">
                <tr>
                    <td><c:out value="${secteurs.id}"/></td>
                    <td><c:out value="${secteurs.nom}"/></td>
                    <td><c:out value="${secteurs.description}"/></td>
                    <td><a href="<c:url value="/secteur/${secteurs.id}/voie"/>">Gestion du secteur</a></td>
                    <td><a href="<c:url value="/secteur/${secteurs.id}/delete"/>">Supprimer le secteur</a></td>
                </tr>
            </c:forEach>
        </div>
    </table>
</body>