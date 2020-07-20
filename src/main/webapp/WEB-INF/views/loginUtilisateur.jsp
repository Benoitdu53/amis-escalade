<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@ include file="header.jsp"%>
</head>

    <body>
        <%--@elvariable id="utilisateur" type="com.escalade.model.Utilisateur"--%>
        <form:form id="loginUtilisateur" method="post" action="/validateLogin" modelAttribute="utilisateur">
            <tr>
                <td><form:label id="pseudo" class="col-md-3 control-label" path="pseudo">Entrez votre pseudo</form:label></td>
                <td><form:input path="pseudo" required="required"/></td>
            </tr>

            <tr>
                <td><form:label id="password" class="col-md-3 control-label" path="password">Entrez votre mot de passe</form:label></td>
                <td><form:input path="password" type="password" required="required"></form:input></td>
            </tr>

            <tr>
                <td><input type="submit" value="Valider"></td></br>
                <td><button><a href="<c:url value="/sites"></c:url>">Retour</a></button></td>
            </tr>
        </form:form>
    </body>
</html>
