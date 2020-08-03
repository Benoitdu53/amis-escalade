<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <%@ include file="header.jsp"%>

<body>

    <section id="image_site">
        <div class="wrapper">
            <h2><c:out value="${site.nom}"/></h2>
        </div>
    </section>

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

    <section id="secteur">
        <div class="wrapper">
            <c:forEach var="secteurs" items="${secteurs}">
            <article>
                <div class="overlay">
                    <h4><c:out value="${secteurs.nom}"/></h4>
                    <p><small><c:out value="${secteurs.description}"/></small></p>
                </div>
            </article>
            </c:forEach>
        </div>
    </section>


    <div class="ajoutSecteur">
        <p><a href="<c:url value="/site/${site.id}/secteur/add"/>">Ajouter un secteur</a> </p>
    </div>

    <!-- Tableau des secteurs -->

    <table border="1" id="tableauSecteurs">
        <div class="titreSecteur">
            <caption>Secteurs</caption>
            <tr>
                <th>id</th>
                <th>Nom</th>
                <th>Description</th>
            </tr>

            <c:forEach var="secteurs" items="${secteurs}">
                <tr>
                    <td><c:out value="${secteurs.id}"/></td>
                    <td><c:out value="${secteurs.nom}"/></td>
                    <td><c:out value="${secteurs.description}"/></td>
                    <td><a href="<c:url value="/secteur/${secteurs.id}/voie"/>">Gestion du secteur</a></td>
                    <td><a href="<c:url value="/secteur/${secteurs.id}/delete"/>">Supprimer le secteur</a></td>
                </tr>
            </c:forEach>
        </div>
    </table>
</body>

<%@ include file="footer.jsp"%>