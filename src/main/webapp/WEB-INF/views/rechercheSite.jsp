<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<p><a href="sites">Tout les sites </a> </p>

<!-- Formulaire de critère de recherche des sites -->
<form id="formulaireSite" method="get" action="sites">

    <!-- Par nom -->
        <select name="nom">
                <option value="">Sélectionner le nom du site</option>
            <c:forEach var="sites" items="${sites}">
                    <option value="${sites.nom}">${sites.nom}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="submit"/>

</form>