<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
    <table border="1">

        <tr>
            <th>id</th>
            <th>nom</th>
            <th>Departement</th>
            <th>Pays</th>
            <th>Nombre de secteur</th>
            <th>Type</th>
            <th>Cotation-min</th>
            <th>Cotation-max</th>
            <th>Longueur-max</th>
        </tr>

        <tr>
            <td><c:out value="${site.id}"/></td>
            <td><c:out value="${site.nom}"/></td>
            <td><c:out value="${site.departement}"/></td>
            <td><c:out value="${site.pays}"/></td>
            <td><c:out value="${site.nbreSecteur}"/></td>
            <td><c:out value="${site.type}"/></td>
            <td><c:out value="${site.cotationMin}"/></td>
            <td><c:out value="${site.cotationMax}"/></td>
            <td><c:out value="${site.longueurMax}"/></td>
        </tr>

    </table>
</body>

