<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Site d'escalade</title>
</head>
<body>
        <table>
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

            <c:forEach items="${param.}"
        </table>
</body>
</html>
