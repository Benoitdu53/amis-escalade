<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <jsp:include page="include/header.jsp"></jsp:include>
    </head>

    <!-- Tableau des utilisateurs -->
    <body>
        <div class="navbarUtilisateurs">
            <p><a href="<c:url value="formUtilisateur"></c:url>">Ajouter un utilisateur</a></p>
        </div>

    <table border="1" id="tableauUtilisateur">
        <caption>Utilisateur(s)</caption>

        <tr>
            <th>id</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Pseudo</th>
            <th>mail</th>
            <th>Mot de passe</th>
            <th>Membre officiel</th>
        </tr>

        <c:forEach var="utilisateurs" items="${utilisateurs}">
        <tr>
            <th><c:out value="${utilisateurs.id}"/></th>
            <th><c:out value="${utilisateurs.nom}"/></th>
            <th><c:out value="${utilisateurs.prenom}"/></th>
            <th><c:out value="${utilisateurs.pseudo}"/></th>
            <th><c:out value="${utilisateurs.mail}"/></th>
            <th><c:out value="${utilisateurs.password}"/></th>
<%--            <th><c:out value="${utilisateurs.isMembreOfficiel}"/></th>--%>
        </tr>
        </c:forEach>
    </table>

    </body>
</html>
