<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous">
<%@ include file="header.jsp" %>
<%@ include file="rechercheSite.jsp" %>

<body>

<div class="container">
    <div class="row">
        <%-- Si utilisateur connecté affiché "Ajouter un site"--%>
        <c:if test="${ not empty sessionScope.pseudo}">
            <div class="navbarSites">
                <p><a href="<c:url value="/formSite"/> " class="button2">Ajouter un site</a></p>
            </div>
        </c:if>
    </div>

    <div class="row">
        <div class="col ">
            <%--Affichage des sites--%>
            <c:forEach var="sites" items="${sites}">
                <section id="sitesSection">
                        <article>
                            <div class="overlay">
                                <c:if test="${sites.tague == true}">
                                    <img src="<c:url value="/resources/img/star.png"/>" alt="Les amis de l'escalade">
                                </c:if>
                                <h4><a href="<c:url value="/site/${sites.id}"/>"><c:out value="${sites.nom}"/></a></h4>
                                <h5><c:out value="${sites.departement}"/></h5>
                                <p><small><c:out value="${sites.description}"/></small></p>

                            </div>
                        </article>
                </section>
            </c:forEach>
        </div>
    </div>

    <div class="clear"></div>

</div>
</body>

<%@include file="footer.jsp" %>
