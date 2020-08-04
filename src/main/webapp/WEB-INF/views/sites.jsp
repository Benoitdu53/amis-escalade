    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <%@ include file="header.jsp"%>
    <%@ include file="rechercheSite.jsp"%>

<body>
<div class="navbarSites">
    <p><a href="<c:url value="/formSite"/> ">Ajouter un site</a></p>
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
                    <a href="<c:url value="/site/${sites.id}"/>" class="button2">Voir le site </a>
                </div>
            </article>
        </div>
    </section>
</c:forEach>
</body>

<%@include file="footer.jsp"%>
