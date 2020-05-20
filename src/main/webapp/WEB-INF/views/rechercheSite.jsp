<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

<!DOCTYPE html>
<html>
    <body>

        <p><a href="sites">Tout les sites </a> </p>

        <!-- Formulaire de critère de recherche des sites -->
        <!-- Critère : Pays, cotation min, type-->
        <form:form id="formulaireSite" method="get" action="/searchSites">

            <select name="pays">
            <div id="pays">
                    <option value="">Sélectionner un pays</option>
                    <c:forEach var="pays" items="${pays}">
                        <option value="${pays}" ${pays==param["pays"]?'selected="selected"':''}> ${pays}</option>
                    </c:forEach>
                </div>
            </select>

            <select name="cotationMin">
                <div id="cotationMin">
                    <option value="0">Sélectionner une cotation minimum</option>
                    <c:forEach var="cotationMin" items="${cotationMin}">
                    <option value="${cotationMin}" ${cotationMin==param["cotationMin"]?'selected="selected"':''}>${cotationMin}</option>
                    </c:forEach>
            </select>
            </div>

            <select name="type">
                <div id="type">
                    <option value="">Sélectionner un type</option>
                    <c:forEach var="type" items="${type}">
                    <option value="${type}" ${type==param["type"]?'selected="selected"':''}>${type}</option>
                    </c:forEach>
                </div>
            </select>

            <input type="submit" value="Rechecher"/>
        </form:form>

    </body>
</html>