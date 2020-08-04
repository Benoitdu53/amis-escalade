<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

        <!-- Formulaire de critère de recherche des sites -->
        <!-- Critère : Pays, département, type-->
        <section id="rechercheSites">
            <div class="wrapper">
        <form:form id="formulaireSite" method="get" action="/searchSites">
            <select name="pays">
                <div class="button2">
                    <option value="">Sélectionner un pays</option>
                    <c:forEach var="pays" items="${pays}">
                        <option value="${pays}" ${pays==param["pays"]?'selected="selected"':''}> ${pays}</option>
                    </c:forEach>
                </div>
            </select>

            <select name="departement">
                <div class="button2">
                    <option value="">Sélectionner un département</option>
                    <c:forEach var="departement" items="${departement}">
                    <option value="${departement}" ${departement==param["departement"]?'selected="selected"':''}> ${departement}</option>
                    </c:forEach>
                </div>
            </select>

            <select name="type">
                <div class="button2">
                    <option value="">Sélectionner un type</option>
                    <c:forEach var="type" items="${type}">
                    <option value="${type}" ${type==param["type"]?'selected="selected"':''}>${type}</option>
                    </c:forEach>
                </div>
            </select>

            <input class="button2" type="submit" value="Rechecher"/>
            </form:form>
            </div>
        </section>