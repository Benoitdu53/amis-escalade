<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <jsp:include page="include/header.jsp"></jsp:include><br>
        <jsp:include page="navBarMenu.jsp"></jsp:include>
        <jsp:include page="rechercheSite.jsp"></jsp:include><br>
    </head>

    <body>

    <c:if test="${empty sessionScope.pseudo}">

        <p><a href="<c:url value="/sites"></c:url>">Tout les sites</a></p>
        <p><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></p>
        <p><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></p>

    </c:if>

    <c:if test="${not empty sessionScope.pseudo}">

        <p><a href="<c:url value="/sites"></c:url>">Tout les sites</a></p>
        <p><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></p>
        <%--            <p><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></p>--%>

    </c:if>

    <div class="navbarSites">
        <p><a href="<c:url value="/formSite"></c:url>">Ajouter un site </a> </p>
    </div>

            <table border="1" id="tableauSites">
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

                <!-- Si aucun critères n'est insérer, on affiche tout les sites -->
                <!-- Sinon on affiche les sites selon les critères -->

                <c:forEach var="sites" items="${sites}">
                    <tr>
                            <td><c:out value="${sites.id}"/></td>
                            <td><c:out value="${sites.nom}"/></td>
                            <td><c:out value="${sites.departement}"/></td>
                            <td><c:out value="${sites.pays}"/></td>
                            <td><c:out value="${sites.type}"/></td>
                            <td><c:out value="${sites.cotationMin}"/></td>
                            <td><c:out value="${sites.cotationMax}"/></td>
                            <td><c:out value="${sites.description}"/></td>
                        <td><a href="<c:url value="site/${sites.id}"></c:url>">Gestion du site </a></td>
                        <td><a href="<c:url value="/site/${site.id}/delete"/>">Supprimer le site</a></td>
                    </tr>
                </c:forEach>

            </table>

            <jsp:include page="include/footer.jsp"></jsp:include><br>
    </body>
</html>
