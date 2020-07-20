<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    </head>
    <body>
    <div class="header-title">
        <div class="header-title">
            <h1>Les amis de l'escalade</h1>
            <h2>Le site communautaire des amis de l'escalade</h2>
        </div>
    </div>

    <%--    Menu de navigation --%>
    <div class="navbar">

        <c:if test="${empty sessionScope.pseudo}">

            <p><a href="<c:url value="/sites"></c:url>">Tout les sites</a></p>
            <p><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></p>
            <p><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></p>
            <p><a href="<c:url value="/formUtilisateur"></c:url>">S'inscrire</a></p>

        </c:if>

        <c:if test="${not empty sessionScope.pseudo}">

            <p><a href="<c:url value="/sites"></c:url>">Tout les sites</a></p>
            <p><a href="<c:url value="/topos"></c:url>">Topos</a></p>
            <p><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></p>
            <p><a href="<c:url value="/deconnexion"></c:url>">Se déconnecter</a></p>

        </c:if>
    </div>

    </body>
</html>
