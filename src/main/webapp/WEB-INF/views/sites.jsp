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
                <th>Nom</th>
                <th>Type</th>
                <th>Secteur</th>
                <th>Voie</th>
                <th>Longueur</th>
                <th>Cotation</th>
                <th>Orientation</th>
            </tr>

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


        </table>
</body>
</html>
