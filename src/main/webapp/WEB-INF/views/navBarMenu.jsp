<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>

    </head>

    <body>

    <%--    Menu de navigation --%>
    <div class="navbar">


        <c:if test="${empty sessionScope.pseudo}">

            <p><a href="<c:url value="/sites"></c:url>">Tout les sites</a></p>
            <p><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></p>
            <p><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></p>

        </c:if>

        <c:if test="${sessionScope.pseudo}">

            <p><a href="<c:url value="/sites"></c:url>">Tout les sites</a></p>
            <p><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></p>
<%--            <p><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></p>--%>

        </c:if>
    </div>
    </body>

</html>
