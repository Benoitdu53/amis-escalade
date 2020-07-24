<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>

<html>
    <head>
        <%@ include file="header.jsp"%>
    </head>

    <body>


    <form:form id="formulaireTopos" method="post" action="/addTopos" modelAttribute="topos">
        <table>
            <div class="nomTopos">
                <tr>
                    <td><label id="nom">Sélectionner un nom de site</label></td>
                    <td>
                        <select name="nom">
                            <c:forEach var="nom" items="${nom}">
                                <option value="${nom}" ${nom==param["nom"]?'selected="selected"':''}>${nom}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </div>

            <div class="descriptionTopos">
                <tr>
                    <td><form:label path="description" id="description">Description du topos</form:label></td>
                    <td><form:input path="description" required="required"/></td>
                </tr>
            </div>

            <div class="lieuTopos">
                <tr>
                    <td><form:label path="lieu" id="lieu">Lieu du topos</form:label></td>
                    <td><form:input path="lieu" required="required"/></td>
                </tr>
            </div>

            <div class="dateTopos">
                <tr>
                    <td><form:label path="date" id="date">Date du topo</form:label></td>
                    <td><form:input path="date" required="required" type="date"/></td>
                </tr>
            </div>

            <div>
                <tr>
                    <td><button value="/profil">Retour</button></td>
                    <td><input type="submit" value="Ajouter un topo"/></td>
                </tr>
            </div>

        </table>
    </form:form>

    </body>
</html>
