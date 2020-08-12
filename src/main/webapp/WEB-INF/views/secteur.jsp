<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<body>

                <%--Affiche de l'image du site--%>
    <section id="image_site">
        <div class="wrapper">
            <h2><c:out value="${site.nom}"/></h2>
        </div>
    </section>

                <c:if test="${sessionScope.isMembre == true}">
                    <div id="tagueSite">
                        <c:choose>
                            <c:when test="${site.tague == false}">
                                <p><a href="<c:url value="/taguerSite/${site.id}"/>" class="button2">Taguer ce site</a></p>
                            </c:when>
                            <c:when test="${site.tague == true}">
                                <p><a href="<c:url value="/deleteTagueSite/${site.id}"/>" class="button2">Supprimer le tague du site</a></p>
                            </c:when>
                        </c:choose>
                    </div>
                </c:if>


                <%-- Affichage des caractéristique du site demandé --%>
    <section id="secteurSection">
        <div class="wrapper">
            <div id="siteDetail">
                <c:if test="${site.tague == true}">
                        <img src="/resources/img/star.png" alt="Les amis de l'escalade">
                </c:if>
                <ul>
                    <li><strong>Nom du site : </strong><c:out value="${site.nom}"/></li>
                    <li><strong>Département : </strong><c:out value="${site.departement}"/></li>
                    <li><strong>Pays : </strong><c:out value="${site.pays}"/></li>
                    <li><strong>Cotation minimum : </strong><c:out value="${site.cotationMin}"/></li>
                    <li><strong>Cotation maximum : </strong><c:out value="${site.cotationMax}"/></li
                    <li><br><strong>Description : </strong><c:out value="${site.description}"/></li>
                </ul>
            </div>
        </div>
    </section>

    <br><br>

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

                <br><br>

                <section id="commentaires">
                    <c:forEach var="commentaire" items="${commentaire}">

                        <div id="commentaire">
                        <c:if test="${empty commentaire.titre}">
                            <h4>Pas de commentaire</h4>
                        </c:if>

                        <c:if test="${not empty commentaire}">

                            <h4><c:out value="${commentaire.titre}"/></h4>
                            <h4><c:out value="${commentaire.dateCommentaire}"/></h4>
                            <h5><small><c:out value="${commentaire.utilisateur.pseudo}"/></small></h5>
                            <c:if test="${not empty sessionScope.isMembre == true}">
                                <p><a href="<c:url value="/commentaire/modifier/${commentaire.id}"/>"class="button4">Modifier le commentaire</a></p>
                                <p><a href="<c:url value="/commentaire/delete/${commentaire.id}"/>"class="button3">Supprime le commentaire</a></p>
                            </c:if>
                            <small>
                                <br>
                                <h4><c:out value="${commentaire.commentaire}"/></h4>
                            </small>
                        </c:if>
                        </div>
                    </c:forEach>
                </section>

        <br>

</body>

<%@ include file="footer.jsp"%>