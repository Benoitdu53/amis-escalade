<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Les amis de l'escalade</title>
    <link href="<c:url value="/resources/css/style.css">"</c:url> rel="stylesheet">
    <link href="https://fr.allfont.net/allfont.css?fonts=crete-round" rel="stylesheet" type="text/css" />
</head>

<header>
    <h1>Les amis de l'escalade</h1>
    <nav>
<%--            Si utilisateur non connecté affiché : --%>
        <ul>
            <c:if test="${empty sessionScope.pseudo}">
                <li><a href="<c:url value="/sites"/>">Tous les sites</a></li>
                <li><a href="<c:url value="/loginUtilisateur"/>">S'authentifier</a></li>
                <li><a href="<c:url value="/formUtilisateur"/>">S'inscrire</a></li>
            </c:if>

<%--            Si utilisateur connecté affiché : --%>
            <c:if test="${ not empty sessionScope.pseudo}">
                <li><a href="<c:url value="/sites"/>">Tout les sites</a></li>
                <li><a href="<c:url value="/topos"/>">Topos</a></li>
                <li><a href="<c:url value="/profil"/>">Mon profil</a></li>
                <li><a href="<c:url value="/deconnexion"/>">Se déconnecter</a></li>
            </c:if>
        </ul>
    </nav>
</header>

<%-- Image du header --%>
<section id="main-image">
    <div class="wrapper">
        <h2><strong>Site d'escalade <br>en France</strong></h2>
    </div>
</section>
