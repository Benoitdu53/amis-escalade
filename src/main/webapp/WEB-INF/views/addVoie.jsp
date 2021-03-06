<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp" %>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div class="idForm">
                <h3>Ajouter une voie</h3>
            </div>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <%--    Formulaire d'ajout d'une voie --%>
            <div class="formulaire">
                <%--@elvariable id="voie" type="com.escalade.model.Voie"--%>
                <form:form id="formulaireVoie" method="post" modelAttribute="voie">
                    <table>
                        <div class="nomSecteur">
                            <tr>
                                <td><form:label id="nom"
                                                path="nom">Indiquer le nom</form:label></td>
                                <td><form:input path="nom" required="required"/></td>
                            </tr>
                        </div>

                        <div class="taille">
                            <tr>
                                <td><form:label id="taille"
                                                path="taille">Indiquer la taille</form:label></td>
                                <td><form:input path="taille" required="required" type="number" min="0"
                                                max="1000"/></td>
                            </tr>
                        </div>

                        <div>
                            <tr>
                                <td><input type="submit" value="Ajouter une voie" class="button2"/></td>
                            </tr>
                        </div>
                    </table>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>

<%@ include file="footer.jsp" %>