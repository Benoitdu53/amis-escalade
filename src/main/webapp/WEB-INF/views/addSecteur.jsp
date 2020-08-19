<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp" %>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <div class="idForm">
                <h3>Ajouter un secteur</h3>
            </div>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="formulaire">
                <form:form id="formulaireSecteur" method="post" modelAttribute="secteur">
                    <table>
                        <div class="nomSecteur">
                            <tr>
                                <td><form:label id="nomSecteur"
                                                path="nom">Nom du secteur</form:label></td>
                                <td><form:input path="nom" required="required"/></td>
                            </tr>
                        </div>

                        <div class="descriptionSecteur">
                            <tr>
                                <td><form:label id="descriptionSecteur"
                                                path="description">Description du secteur</form:label></td>
                                <td><form:input path="description" required="required"/></td>
                            </tr>
                        </div>

                        <div>
                            <tr>
                                <td><input type="submit" value="Ajouter un secteur" class="button3"/></td>
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

