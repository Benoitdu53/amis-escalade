<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp" %>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <%--Si utilisateur connecté affiché "Ajouter une voie"--%>
            <c:if test="${not empty sessionScope.pseudo}">
                <div class="ajoutVoie">
                    <p><a href="<c:url value="/secteur/${secteur.id}/voie/add"/>" class="button2">Ajouter une voie</a>
                    </p>
                </div>
            </c:if>
        </div>
    </div>


    <div class="row">
        <div class="col-12">
            <div class="idForm">
                <h3>Voies</h3>
            </div>
        </div>
    </div>

    <div class="clear"></div>

    <div class="row">
        <div class="col-4">
            <!-- Tableau des voies -->
            <table id="voies">
                <tr>
                    <th>Nom</th>
                    <th>Taille</th>
                </tr>

                <c:forEach var="voies" items="${voies}">
                    <tr>
                        <td><c:out value="${voies.nom}"/></td>
                        <td><c:out value="${voies.taille}"/></td>
                        <td><a href="<c:url value="/voie/${voies.id}/longueur"/>" class="button2">Voir la voie</a></td>
                        <c:if test="${not empty sessionScope.pseudo}">
                            <td><a href="<c:url value="/voie/${voies.id}/delete"/>" class="button3">Supprimer la
                                voie</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>

<%@ include file="footer.jsp" %>