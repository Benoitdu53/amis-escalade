<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp" %>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div class="idForm">
                <h3>S'inscrire</h3>
            </div>
        </div>
    </div>


    <div class="clear"></div>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <%--    Formulaire d'inscription utilisateur --%>
            <div class="row justify-content-center">
                <div class="formulaire">
                    <form:form id="formulaireUtilisateur" method="post" action="/registrationUtilisateur"
                               modelAttribute="utilisateur">
                        <div class="col-md-6 col-sm-12 ">
                            <table>
                                <tr>
                                    <td><form:label id="nom" path="nom">Entrez votre nom*</form:label></td>
                                    <td><form:input path="nom" required="required"/></td>
                                </tr>

                                <br>

                                <tr>
                                    <td><form:label id="prenom" path="prenom">Entrez votre prénom*</form:label></td>
                                    <td><form:input path="prenom" required="required"/></td>
                                </tr>

                                <br>

                                <tr>
                                    <td><form:label id="pseudo" path="pseudo">Entrez votre pseudo*</form:label></td>
                                    <td><form:input path="pseudo" required="required"/></td>
                                    <td><span class="erreur"><c:out value="${erreurMessages['pseudoErreur']}"/></span>
                                    </td>
                                </tr>

                                <br>

                                <tr>
                                    <td><form:label id="mail" path="mail">Entrez votre mail*</form:label></td>
                                    <td><form:input path="mail" required="required" type="email"/></td>
                                    <td><span class="erreur"><c:out value="${erreurMessages['mailErreur']}"/></span>
                                    </td>
                                </tr>

                                <br>

                                <tr>
                                    <td><form:label id="password"
                                                    path="password">Entrez votre mot de passe*</form:label></td>
                                    <td><form:input path="password" type="password" required="required"/></td>
                                    <td><span class="erreur"><c:out
                                            value="${erreurMessages['confirmationMdp']}"/></span></td>
                                </tr>

                                <br>

                                <tr>
                                    <td><label id="confirmationPassword" path="confirmationPassword">Confirmer le mot de
                                        passe*</label></td>
                                    <td><input name="confirmationPassword" type="password" required="required"/></td>
                                    <td><span class="erreur"><c:out
                                            value="${erreurMessages['confirmationMdp']}"/></span></td>
                                </tr>

                                <br>

                                <tr>
                                    <td><input type="submit" value="Valider" class="button2"></td>
                                </tr>
                                <p><FONT color="red">* Champ obligatoire</FONT></p>
                            </table>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<%@include file="footer.jsp" %>

