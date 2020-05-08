<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Site d'escalade</title>
</head>
<body>

    <jsp:include page="rechercheSite.jsp"></jsp:include><br>
        <table border="1">
            <tr>
                <th>id</th>
                <th>Localisation</th>
                <th>Type</th>
                <th>Secteur</th>
                <th>Voie</th>
                <th>Longueur</th>
                <th>Cotation</th>
                <th>Orientation</th>
            </tr>


        <c:choose>
            <!-- Si un aucun critères n'est insérer, on affiche tout les sites -->
            <c:when test="${empty sitesCritere}">
            <c:forEach var="sites" items="${sites}">
                <tr>
                        <td><c:out value="${sites.id}"/></td>
                        <td><c:out value="${sites.nom}"/></td>
                        <td><c:out value="${sites.type}"/></td>
                        <td><c:out value="${sites.secteur}"/></td>
                        <td><c:out value="${sites.voie}"/></td>
                        <td><c:out value="${sites.longueur}"/></td>
                        <td><c:out value="${sites.cotation}"/></td>
                        <td><c:out value="${sites.orientation}"/></td>
                </tr>
            </c:forEach>
            </c:when>
            <!-- Si un critère est detecté on affiche les sites selon les critères -->
            <c:otherwise>
                <c:forEach var="sites" items="${sitesCritere}">
                    <tr>
                        <td><c:out value="${sites.id}"/></td>
                        <td><c:out value="${sites.nom}"/></td>
                        <td><c:out value="${sites.type}"/></td>
                        <td><c:out value="${sites.secteur}"/></td>
                        <td><c:out value="${sites.voie}"/></td>
                        <td><c:out value="${sites.longueur}"/></td>
                        <td><c:out value="${sites.cotation}"/></td>
                        <td><c:out value="${sites.orientation}"/></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </table>
</body>
</html>
