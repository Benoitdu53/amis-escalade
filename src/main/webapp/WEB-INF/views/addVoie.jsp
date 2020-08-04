<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<body>

    <div class="idForm">
        <h3>Ajouter une voie</h3>
    </div>

    <div class="formulaire">
        <%--@elvariable id="voie" type="com.escalade.model.Voie"--%>
        <form:form id="formulaireVoie" method="post" modelAttribute="voie">
            <table>
                <div class="nomSecteur">
                    <tr>
                        <td><form:label id="nom" class="col-md-3 control-label" path="nom">Indiquer le nom</form:label></td>
                        <td><form:input path="nom" required="required"/></td>
                    </tr>
                </div>

                <div class="taille">
                    <tr>
                        <td><form:label id="taille" class="col-md-3 control-label" path="taille">Indiquer la taille</form:label></td>
                        <td><form:input path="taille" required="required" type="number" min="0" max="1000"/></td>
                    </tr>
                </div>

                <div>
                    <tr>
                        <td><button><a href="<c:url value="/sites"></c:url>" class="button3">Retour</a></button></td>
                        <td><input type="submit" value="Ajouter une voie" class="button2"/></td>
                    </tr>
                </div>
            </table>
        </form:form>
    </div>
</body>

<%@ include file="footer.jsp"%>