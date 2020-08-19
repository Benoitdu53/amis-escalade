<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Les amis de l'escalade</title>

    <link href="<c:url value="/resources/css/style.css">"</c:url> rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css">"</c:url> rel=""
    <link href="https://fr.allfont.net/allfont.css?fonts=crete-round" rel="stylesheet" type="text/css"/>

    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</head>

<header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 col-md-6">
                <h1>Les amis de l'escalade</h1>
            </div>

            <div class="col-12 col-md-6">
            <nav class="col navbar navbar-expand-lg navbar-light">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div id="navbarContent" class="collapse navbar-collapse">
                    <%--            Si utilisateur non connecté affiché : --%>
                    <c:if test="${empty sessionScope.pseudo}">
                        <ul class="navbar-nav">
                            <li class="nav-item active"><a class="nav-link" href="<c:url value="/sites"/>">Tous les
                                sites</a></li>
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/loginUtilisateur"/>">S'authentifier</a>
                            </li>
                            <li class="nav-item"><a class="nav-link"
                                                    href="<c:url value="/formUtilisateur"/>">S'inscrire</a></li>
                        </ul>
                    </c:if>


                    <%--            Si utilisateur connecté affiché : --%>
                    <c:if test="${ not empty sessionScope.pseudo}">
                        <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/sites"/>">Tout les
                                sites</a></li>
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/topos"/>">Topos</a></li>
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/profil"/>">Mon profil</a></li>
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/deconnexion"/>">Se
                                déconnecter</a></li>
                        </ul>
                    </c:if>
                </div>
            </nav>
        </div>
    </div>
    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <%-- Image du header --%>
            <section id="main-image">
                <div class="wrapper">
                    <h2><strong>Site d'escalade <br>en France</strong></h2>
                </div>
            </section>
        </div>
    </div>
</div>

