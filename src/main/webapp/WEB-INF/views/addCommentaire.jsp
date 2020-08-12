<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<body>

    <div class="idForm">
        <h3>Ajouter un commentaire</h3>
    </div>

    <div class="clear"></div>

    <div class="formulaire">
    <%--@elvariable id="commentaire" type="com.escalade.model.Commentaire"--%>
    <form:form id="formulaireCommentaire" method="post" action="/addCommentaire/${idSite}" modelAttribute="commentaire">
        <table>
            <div class="titre">
                <tr>
                    <td><form:label id="titre" class="col-md-3 control-label" path="titre">Titre du commentaire</form:label></td>
                    <td><form:input path="titre" required="required"/></td>
                </tr>
            </div>

            <div class="commentaire">
                <tr>
                    <td><form:label id="commentaire" class="col-md-3 control-label" path="commentaire">Commentaire</form:label></td>
                    <td><form:textarea rows="5" cols="35" path="commentaire" required="required"/>toto</td>
                </tr>
            </div>

            <div>
                <tr>
                    <td><form:button type="submit" value="Ajouter un commentaire" class="button2">Ajouter un commentaire</form:button></td>
                </tr>
            </div>

        </table>
    </form:form>
    </div>
</body>

<%@include file="footer.jsp"%>

