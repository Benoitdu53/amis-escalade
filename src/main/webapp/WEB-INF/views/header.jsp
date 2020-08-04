<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="https://fr.allfont.net/allfont.css?fonts=crete-round" rel="stylesheet" type="text/css" />
    </head>
        <header>
            <h1>Les amis de l'escalade</h1>
            <nav>
                <ul>
                    <c:if test="${empty sessionScope.pseudo}">
                        <li><a href="<c:url value="/sites"></c:url>">Tout les sites</a></li>
                        <li><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></li>
                        <li><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></li>
                        <li><a href="<c:url value="/formUtilisateur"></c:url>">S'inscrire</a></li>
                    </c:if>
                    <c:if test="${ not empty sessionScope.pseudo}">

                        <li><a href="<c:url value="/sites"></c:url>">Tout les sites</a></li>
                        <li><a href="<c:url value="/utilisateurs"></c:url>">Gestion des utilisateurs</a></li>
                        <li><a href="<c:url value="/loginUtilisateur"></c:url>">S'authentifier</a></li>
                        <li><a href="<c:url value="/formUtilisateur"></c:url>">S'inscrire</a></li>

                    </c:if>

                </ul>
            </nav>
        </header>

            <section id="main-image">
                <div class="wrapper">
                    <h2><strong>Site d'escalade <br>en France</strong></h2>
                </div>
            </section>

