<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>

<html>
    <head>
        <title>Mon profil</title>
        <%@include file="header.jsp"%>
    </head>

        <%--    On affiche le profil de l'utilisateur--%>
        <%--    Avec l'adresse mail et le pseudo + ses topos et ses demandes en cours--%>
    <body>
    <div class="navbarSites">
        <p><a href="<c:url value="/formTopos"></c:url>">Enregistrer un topo</a></p>
    </div>

    <div class="mesTopos">
    <table border="1" id="tableauTopos">
        <caption>Mes topos</caption>
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
                </c:if>
            </tr>
        </c:forEach>
    </table>
    </div>

    <br><br>

    <div class="DemandeRecus">
        <table border="1" id="tableau DemandeRecus">
            <caption>Mes demandes de réservation reçu(s)</caption>
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
                    <td><c:out value="${demandeRecus.topos.isReserve == false ? 'Disponible' : ' Non disponible'}"/></td>
                    <td><c:out value="${demandeRecus.topos.date}"/></td>
                    <td><c:out value="${demandeRecus.utilisateur.pseudo}"/></td>
                        <c:if test="${demandeRecus.status.equals('En attente de réponse')}">
                            <td><a href="<c:url value="/accepterDemande/${demandeRecus.id}/${demandeRecus.topos.id}"/>">Accepter</a></td>
                            <td><a href="<c:url value="/refuserDemande/${demandeRecus.id}/${demandeRecus.topos.id}"/>">Refuser</a></td>
                        </c:if>
                        <c:if test="${demandeRecus.status.equals('En location')}">
                            <td><a href="<c:url value="/deleteReservation/${demandeRecus.id}/${demandeRecus.topos.id}"/>">Remettre disponible</a></td>
                        </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>

    <br><br>

    <div class="DemandeEnvoye">
        <table border="1" id="DemandeEnvoye">
            <caption>Mes demandes envoyé(s)</caption>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Lieu</th>
                <th>Date</th>
                <th>Propriétaire du topo</th>
            </tr>


            <c:forEach var="demandeEnvoye" items="${demandeEnvoye}">
                <tr>
                    <td><c:out value="${demandeEnvoye.topos.id}"/></td>
                    <td><c:out value="${demandeEnvoye.topos.nom}"/></td>
                    <td><c:out value="${demandeEnvoye.topos.description}"/></td>
                    <td><c:out value="${demandeEnvoye.topos.lieu}"/></td>
                    <td><c:out value="${demandeEnvoye.topos.date}"/></td>
                    <td><c:out value="${demandeEnvoye.topos.utilisateur.pseudo}"/></td>
                    <td><a href="<c:url value="/deleteReservation/${demandeEnvoye.id}/${demandeEnvoye.topos.id}"/>">Annuler la réservation</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    </body>
</html>
