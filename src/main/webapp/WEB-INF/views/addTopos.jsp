<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div class="idForm">
                <h3>Ajouter un topo</h3>
            </div>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="formulaire">
                <form:form id="formulaireTopos" method="post" action="addTopos" modelAttribute="topos">
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
                                <td><form:label path="description"
                                                id="description">Description du topos</form:label></td>
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
                                <td><input type="submit" value="Ajouter un topo" class="button2"/></td>
                            </tr>
                        </div>
                    </table>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>

<%@include file="footer.jsp" %>
