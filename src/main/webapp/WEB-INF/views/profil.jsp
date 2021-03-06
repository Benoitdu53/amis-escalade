<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@include file="header.jsp" %>

<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="navbarSites">
                <p><a href="<c:url value="/formTopos"></c:url>" class="button2">Enregistrer un topo</a></p>
            </div>

            <%--    Mes topos   --%>
            <div class="idForm">
                <h3>Mes topos</h3>
            </div>

            <div class="mesTopos">
                <table class="topos">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Lieu</th>
                        <th>Réserver</th>
                        <th>Date</th>
                    </tr>

                    <c:forEach var="topo" items="${topos}">
                        <tr>
                            <c:if test="${empty topos}">
                                <td>Vous n'avez aucun topo(s)</td>
                            </c:if>
                            <c:if test="${not empty topo}">
                                <td><c:out value="${topo.id}"/></td>
                                <td><c:out value="${topo.nom}"/></td>
                                <td><c:out value="${topo.description}"/></td>
                                <td><c:out value="${topo.lieu}"/></td>
                                <td><c:out value="${topo.isReserve == false ? 'Disponible' : ' Non disponible'}"/></td>
                                <td><c:out value="${topo.date}"/></td>
                                <td>
                                    <c:if test="${topo.isReserve == null}">
                                        <a href="<c:url value="/disponible/${topo.id}"/>">Mettre disponible</a></td>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="<c:url value="/topos/${topo.id}/delete"/>">Supprimer le topo</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<br><br>

<div class="container">
    <div class="row">
        <div class="col-12">
            <%--    Mes demandes de réservation topos reçu  --%>
            <div class="idForm">
                <h3>Mes demandes reçus</h3>
            </div>

            <div class="DemandeRecus">
                <table class="topos">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Lieu</th>
                        <th>Réserver</th>
                        <th>Date</th>
                        <th>Demandeur</th>
                    </tr>


                    <c:forEach var="demandeRecus" items="${demandeRecus}">
                        <tr>
                            <td><c:out value="${demandeRecus.topos.id}"/></td>
                            <td><c:out value="${demandeRecus.topos.nom}"/></td>
                            <td><c:out value="${demandeRecus.topos.description}"/></td>
                            <td><c:out value="${demandeRecus.topos.lieu}"/></td>
                            <td><c:out
                                    value="${demandeRecus.topos.isReserve == false ? 'Disponible' : ' Non disponible'}"/></td>
                            <td><c:out value="${demandeRecus.topos.date}"/></td>
                            <td><c:out value="${demandeRecus.utilisateur.pseudo}"/></td>
                            <c:if test="${demandeRecus.status == 'En attente de reponse'}">
                                <td>
                                    <a href="<c:url value="/accepterDemande/${demandeRecus.id}/${demandeRecus.topos.id}"/>"
                                       class="button2">Accepter</a></td>
                                <td>
                                    <a href="<c:url value="/refuserDemande/${demandeRecus.id}/${demandeRecus.topos.id}"/>"
                                       class="button3">Refuser</a></td>
                            </c:if>
                            <c:if test="${demandeRecus.status.equals('En location')}">
                                <td>
                                    <a href="<c:url value="/deleteReservation/${demandeRecus.id}/${demandeRecus.topos.id}"/>"
                                       class="button2">Remettre disponible</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<br><br>


<div class="container">
    <div class="row">
        <div class="col-12">
            <%--    Mes demandes de réservation expédié(s)--%>
            <div class="idForm">
                <h3>Mes demandes expedié(s)</h3>
            </div>

            <div class="clear"></div>

            <div class="DemandeEnvoye">
                <table class="topos">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Lieu</th>
                        <th>Date</th>
                    </tr>

                    <c:forEach var="demandeEnvoye" items="${demandeEnvoye}">
                        <tr>
                            <td><c:out value="${demandeEnvoye.topos.id}"/></td>
                            <td><c:out value="${demandeEnvoye.topos.nom}"/></td>
                            <td><c:out value="${demandeEnvoye.topos.description}"/></td>
                            <td><c:out value="${demandeEnvoye.topos.lieu}"/></td>
                            <td><c:out value="${demandeEnvoye.topos.date}"/></td>
                            <c:if test="${demandeEnvoye.status == 'En attente de reponse'}">
                                <td>
                                    <a href="<c:url value="/deleteReservation/${demandeEnvoye.id}/${demandeEnvoye.topos.id}"/>"
                                       class="button3">Annuler la réservation</a></td>
                            </c:if>
                            <c:if test="${demandeEnvoye.status == 'En location'}">
                                <td>Pseudo du propriétaire : <c:out value="${demandeEnvoye.topos.utilisateur.nom}"/>
                                    <c:out value="${demandeEnvoye.topos.utilisateur.prenom}"/></td>
                                <td>Mail du propriétaire : <c:out value="${demandeEnvoye.topos.utilisateur.mail}"/></td>
                            </c:if>
                        </tr>
                        <br>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>

<%@ include file="footer.jsp" %>
