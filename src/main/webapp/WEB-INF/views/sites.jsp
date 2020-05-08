<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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


            <!-- Si aucun critères n'est insérer, on affiche tout les sites -->
            <!-- Sinon on affiche les sites selon les critères -->
        <c:choose>
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
