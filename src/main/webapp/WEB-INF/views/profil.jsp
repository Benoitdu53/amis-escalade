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


        <c:forEach var="topos" items="${topos}">
            <tr>
                <c:if test="${empty topos}">
                    <td>Vous n'avez aucun topo(s)</td>
                </c:if>
                <c:if test="${not empty topos}">
                    <td><c:out value="${topos.id}"/></td>
                    <td><c:out value="${topos.nom}"/></td>
                    <td><c:out value="${topos.description}"/></td>
                    <td><c:out value="${topos.lieu}"/></td>
                    <td><c:out value="${empty topos.isReserve ? 'Disponible' : ' Non disponible'}"/></td>
                    <td><c:out value="${topos.date}"/></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    </div>


    <div class="mesDemandesTopos">
        <table border="1" id="tableau Topos">
            <caption>Mes demandes</caption>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Lieu</th>
                <th>Réserver</th>
                <th>Date</th>
            </tr>


            <c:forEach var="toposDemandeAttente" items="${toposDemandeAttente}">
                <tr>
                    <c:if test="${empty toposDemandeAttente}">
                        <td>Vous n'avez aucun topo(s)</td>
                    </c:if>
                    <c:if test="${not empty toposDemandeAttente}">
                        <td><c:out value="${toposDemandeAttente.id}"/></td>
                        <td><c:out value="${toposDemandeAttente.nom}"/></td>
                        <td><c:out value="${toposDemandeAttente.description}"/></td>
                        <td><c:out value="${toposDemandeAttente.lieu}"/></td>
                        <td><c:out value="${empty toposDemandeAttente.isReserve ? 'Disponible' : ' Non disponible'}"/></td>
                        <td><c:out value="${toposDemandeAttente.date}"/></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>


    <div class="AttenteReponse">
        <table border="1" id="ToposattenteReponse">
            <caption>Mes demandes reçu(s)</caption>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Lieu</th>
                <th>Réserver</th>
                <th>Date</th>
            </tr>


            <c:forEach var="toposAttenteReponse" items="${toposAttenteReponse}">
                <tr>
                    <c:if test="${empty toposAttenteReponse}">
                        <td>Vous n'avez aucun topo(s)</td>
                    </c:if>
                    <c:if test="${not empty toposAttenteReponse}">
                        <td><c:out value="${toposAttenteReponse.id}"/></td>
                        <td><c:out value="${toposAttenteReponse.nom}"/></td>
                        <td><c:out value="${toposAttenteReponse.description}"/></td>
                        <td><c:out value="${toposAttenteReponse.lieu}"/></td>
                        <td><c:out value="${toposAttenteReponse.date}"/></td>

                        <td><a href="<c:url value="/accepterDemande">Accepter la demande</c:url>"/></td>
                        <td><a href="<c:url value="/refuserDemande">Refuser la demande</c:url>"/></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="toposUtilisateur">
        <table border="1" id="toposUtilisateur">
            <caption>Mes demandes reçu(s)</caption>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Lieu</th>
                <th>Réserver</th>
                <th>Date</th>
            </tr>



                <tr>
                    <c:if test="${empty toposUtilisateur}">
                        <td>Vous n'avez aucun topo(s)</td>
                    </c:if>
                    <c:if test="${not empty toposUtilisateur}">
                        <td><c:out value="${toposUtilisateur.topos}"/></td>
                        <td><c:out value="${toposUtilisateur.nom}"/></td>
                        <td><c:out value="${toposUtilisateur.description}"/></td>
                        <td><c:out value="${toposUtilisateur.lieu}"/></td>
                        <td><c:out value="${toposUtilisateur.date}"/></td>

                        <td><a href="<c:url value="/accepterDemande">Accepter la demande</c:url>"/></td>
                        <td><a href="<c:url value="/refuserDemande">Refuser la demande</c:url>"/></td>
                    </c:if>
                </tr>

        </table>
    </div>
    </body>
</html>
