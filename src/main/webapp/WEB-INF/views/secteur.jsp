<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <%@ include file="header.jsp"%>

<body>

                <%--Affiche de l'image du site--%>
    <section id="image_site">
        <div class="wrapper">
            <h2><c:out value="${site.nom}"/></h2>
        </div>
    </section>

                <%-- Affichage des caractéristique du site demandé --%>
    <section id="secteurSection">
        <div class="wrapper">
            <div id="siteDetail">
                <ul>
                    <li><strong>Département</strong> : <c:out value="${site.departement}"/></li>
                    <li><strong>Pays : </strong><c:out value="${site.pays}"/></li>
                    <li><strong>Cotation minimum : </strong><c:out value="${site.cotationMin}"/></li>
                    <li><strong>Cotation maximum : </strong><c:out value="${site.cotationMax}"/></li
                    <li><br><strong>Description : </strong><c:out value="${site.description}"/></li>
                </ul>
            </div>
        </div>
    </section>

                <%-- Affiche du titre et si User connecté affiché "Ajouter un secteur" --%>
    <div class="titre">
        <p><strong><U>Secteur(s):</U></strong></p>
    </div>
    <br>
    <div class="buttonAdd">
        <c:if test="${not empty sessionScope.pseudo}">
            <p><a href="<c:url value="/site/${site.id}/secteur/add"/>"class="button4">Ajouter un secteur</a></p>
        </c:if>
    </div>
    <br>

                <%-- Affichage des secteurs --%>
    <section id="secteur">
        <div class="wrapper">
            <c:forEach var="secteurs" items="${secteurs}">
            <article>
                <div class="overlay">
                    <h4><c:out value="${secteurs.nom}"/></h4>
                    <p><small><c:out value="${secteurs.description}"/></small></p>
                    <br><br>
                    <a href="<c:url value="/secteur/${secteurs.id}/voie"/>"class="button2">Voir le secteur</a>
                    <br><br>
                    <a href="<c:url value="/secteur/${secteurs.id}/delete"/>"class="button3">Supprimer le secteur</a>
                </div>
            </article>
            </c:forEach>
        </div>
    </section>

    <div class="clear"></div>

                <%-- Affichage des commentaires du site --%>
        <div class="titre">
            <p><strong><U>Commentaire(s):</U></strong></p>
        </div>
        <br>
        <div class="buttonAdd">
            <c:if test="${not empty sessionScope.pseudo}">
                <p><a href="<c:url value="/site/${site.id}/add/commentaire"/>"class="button4">Ajouter un commentaire</a></p>
            </c:if>
        </div>
        <br>

    <section id="commentaires">
        <c:forEach var="commentaire" items="${commentaire}">

            <div id="commentaire">
                <c:if test="${empty commentaire.titre}">
                        <h4>Pas de commentaire</h4>
                </c:if>

                <c:if test="${not empty commentaire}">

                        <h4><c:out value="${commentaire.titre}"/></h4>
                        <h5><c:out value="${commentaire.dateCommentaire}"/></h5>
                        <c:if test="${not empty sessionScope.pseudo}">
                            <p><a href="<c:url value="/site/${site.id}/secteur/delete/commentaire"/>"class="button3">Supprime le commentaire</a></p>
                        </c:if>
                        <p><small>
                            <c:out value="${commentaire.utilisateur.pseudo}"/>
                            <br>
                            <h4><c:out value="${commentaire.commentaire}"/></h4>
                        </small></p>
            </div>
            </c:if>
        </c:forEach>
    </section>

</body>

<%@ include file="footer.jsp"%>