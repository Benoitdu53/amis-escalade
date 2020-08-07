    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <%@ include file="header.jsp"%>
    <%@ include file="rechercheSite.jsp"%>

<body>

<c:if test="${ not empty sessionScope.pseudo}">
    <div class="navbarSites">
        <p><a href="<c:url value="/formSite"/> " class="button2">Ajouter un site</a></p>
    </div>
</c:if>

        <%--Affichage des sites--%>

<c:forEach var="sites" items="${sites}">
    <section id="sitesSection">
        <div class="wrapper">
            <article>
                <div class="overlay">
                    <c:if test="${sites.tague == true}">
                            <img src="/resources/img/star.png" alt="Les amis de l'escalade">
                    </c:if>
                    <h4><c:out value="${sites.nom}"/></h4>
                    <h5><c:out value="${sites.departement}"/></h5>
                    <p><small><c:out value="${sites.description}"/></small></p>
                    <br><br><br>
                    <a href="<c:url value="/site/${sites.id}"/>" class="button2">Voir le site </a>
                </div>
            </article>
        </div>
    </section>
</c:forEach>
</body>

<%@include file="footer.jsp"%>
