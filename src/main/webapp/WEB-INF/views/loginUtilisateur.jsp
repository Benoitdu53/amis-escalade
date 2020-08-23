<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-12">
        <div class="idForm">
            <h3>Authentification</h3>
        </div>
    </div>
    </div>

    <div class="clear"></div>

<%--Formulaire de login utilisateur--%>
    <body>
    <div class="row justify-content-center">
        <div class="formulaire">
            <div class="col-md-6">
        <%--@elvariable id="utilisateur" type="com.escalade.model.Utilisateur"--%>
        <form:form id="loginUtilisateur" method="post" action="validateLogin" modelAttribute="utilisateur">

            <tr>
                <td><form:label id="pseudo" path="pseudo">Entrez votre pseudo</form:label></td>
                <td><form:input path="pseudo" required="required"/></td>
            </tr>

            <br>

            <tr>
                <td><form:label id="password" path="password">Entrez votre mot de passe</form:label></td>
                <td><form:input path="password" type="password" required="required"></form:input></td>
            </tr>

            <br>

            <tr>
                <td><span class="erreur"><c:out value="${erreurMessage}"/></span></td>
            </tr>

            <br>

            <tr>
                <td><form:button type="submit" value="Valider" class="button2">Validez</form:button></td></br>
            </tr>

        </form:form>
            </div>
        </div>
    </div>
    </body>
</div>

    <%@ include file="footer.jsp"%>
