<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

    <body>

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

            <select name="departement">
                <div id="departement">
                    <option value="">Sélectionner un département</option>
                    <c:forEach var="departement" items="${departement}">
                    <option value="${departement}" ${departement==param["departement"]?'selected="selected"':''}> ${departement}</option>
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