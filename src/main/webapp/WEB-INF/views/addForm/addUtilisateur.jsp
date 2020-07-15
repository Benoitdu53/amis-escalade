<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@ include file="../header.jsp"%>
    </head>

    <body>
        <form:form id="formulaireUtilisateur" method="post" action="/registrationUtilisateur" modelAttribute="utilisateur">
            <table>
                <div class="nom">
                    <tr>
                        <td><form:label id="nom" class="col-md-3 control-label" path="nom">Entrez votre nom*</form:label></td>
                        <td><form:input path="nom" required="required"/></td>
                    </tr>
                </div>

                <div class="prenom">
                    <tr>
                        <td><form:label id="prenom" class="col-md-3 control-label" path="prenom">Entrez votre prénom*</form:label></td>
                        <td><form:input path="prenom" required="required"/></td>
                    </tr>
                </div>
                <div class="pseudo">
                    <tr>
                        <td><form:label id="pseudo" class="col-md-3 control-label" path="pseudo">Entrez votre pseudo*</form:label></td>
                        <td><form:input path="pseudo" required="required"/></td>
                    </tr>
                </div>
                <div class="mail">
                    <tr>
                        <td><form:label id="mail" class="col-md-3 control-label" path="mail">Entrez votre mail*</form:label></td>
                        <td><form:input path="mail" required="required" type="email"/></td>
                    </tr>
                </div>
                <div class="password">
                    <tr>
                        <td><form:label id="password" class="col-md-3 control-label" path="password">Entrez votre mot de passe*</form:label></td>
                        <td><form:input path="password" type="password" required="required"/></td>
                        <td><span class="erreur"><c:out value="${erreurMessages['confirmationMdp']}"/></span></td>
                    </tr>
                </div>

                <div class="confirmationPassword">
                    <tr>
                        <td><form:label id="confirmationPassword" class="col-md-3 control-label" path="confirmationPassword">Confirmer le mot de passe*</form:label></td>
                        <td><form:input path="confirmationPassword" type="password" required="required"/></td>
                        <td><span class="erreur"><c:out value="${erreurMessages['confirmationMdp']}"/></span></td>
                    </tr>
                </div>

                <div>
                    <tr>
                        <td><input type="submit" value="Valider"></td>
                    </tr>
                </div>
                <p>* Champ obligatoire</p>
            </table>
        </form:form>
    </body>

</html>
