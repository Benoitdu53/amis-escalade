<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <%@ include file="header.jsp"%>
        <%@ include file="rechercheSite.jsp"%><br>
    </head>

    <body>
        <div class="navbarSites">
            <p><a href="<c:url value="/formSite"></c:url>">Ajouter un site</a></p>
        </div>


        <c:forEach var="sites" items="${sites}">
            <section id="sitesSection">
                <div class="wrapper">
                    <article>
                        <div class="overlay">
                            <h4><c:out value="${sites.nom}"/></h4>
                            <h5><c:out value="${sites.departement}"/></h5>
                            <p><small><c:out value="${sites.description}"/></small></p>
                            <br><br><br>
                            <a href="<c:url value="site/${sites.id}"></c:url>" class="button2">Voir le site </a>
                        </div>
                    </article>
                </div>
            </section>
        </c:forEach>
    </body>

    <%@include file="footer.jsp"%>
