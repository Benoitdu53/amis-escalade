<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<div class="idForm">
    <h3>Authentification</h3>
</div>

<%--Formulaire de login utilisateur--%>
    <body>
        <div class="formulaire">
        <%--@elvariable id="utilisateur" type="com.escalade.model.Utilisateur"--%>
        <form:form id="loginUtilisateur" method="post" action="/validateLogin" modelAttribute="utilisateur">
            <tr>
                <td><form:label id="pseudo" class="col-md-3 control-label" path="pseudo">Entrez votre pseudo</form:label></td>
                <td><form:input path="pseudo" required="required"/></td>
            </tr>
            <br>
            <tr>
                <td><form:label id="password" class="col-md-3 control-label" path="password">Entrez votre mot de passe</form:label></td>
                <td><form:input path="password" type="password" required="required"></form:input></td>
            </tr>
            <br>
            <tr>
                <td><input type="submit" value="Valider" class="button2"></td></br>
            </tr>
        </form:form>
        </div>
    </body>

    <%@ include file="footer.jsp"%>
