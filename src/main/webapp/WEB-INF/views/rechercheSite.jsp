<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Formulaire de critère de recherche des sites -->
<form id="formulaireSite" method="get" action="sites.jsp">

    <!-- Par nom -->
        <select name="nom">
                <option value=""></option>
            <c:forEach var="sites" items="${sites}">
                    <option value="${sites.nom}">${sites.nom}</option>
            </c:forEach>
        </select>

    <!-- Par type -->
        <select name="type">
                <option value=""></option>
                <option value="bloc">Bloc</option>
                <option value="falaise">Falaise</option>
        </select>

    <!-- Par cotation -->
        <select name="cotation">
                <option value=""></option>
            <c:forEach var="sites" items="${sites}">
                <option value="${sites.cotation}">${sites.cotation}</option>
            </c:forEach>
        </select>

    <!-- Par longueur -->
        <select name="longueur">
                <option value=""></option>
                <option value="inf"> Inférieur à 50m</option>
                <option value="sup"> Supérieur ou égale à 50m</option>
        </select>

</form>