<%@ page contentType="text/html;charset=UTF-8" %>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp" %>

<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-12">
            <div class="idForm">
                <h3>Ajouter un commentaire</h3>
            </div>
        </div>
    </div>

    <div class="clear"></div>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="formulaire">
                <%--@elvariable id="commentaire" type="com.escalade.model.Commentaire"--%>
                <form:form id="formulaireCommentaire" method="post" action="/addCommentaire/${idSite}"
                           modelAttribute="commentaire">
                    <form:hidden path="id"/>

                    <table>
                        <div class="titre">
                            <tr>
                                <td><form:label id="titre" path="titre">Titre du commentaire</form:label></td>
                                <td><form:input path="titre" required="required"/></td>
                            </tr>
                        </div>

                        <div class="commentaire">
                            <tr>
                                <td><form:label id="commentaire" path="commentaire">Commentaire</form:label></td>
                                <td><form:textarea rows="5" cols="35" path="commentaire" required="required"/></td>
                            </tr>
                        </div>

                        <c:if test="${ empty commentaire.id}">
                            <div>
                                <tr>
                                    <td><form:button type="submit" value="Ajouter un commentaire"
                                                     class="button2">Ajouter un commentaire</form:button></td>
                                </tr>
                            </div>
                        </c:if>

                        <c:if test="${ not empty commentaire.id}">
                            <div>
                                <tr>
                                    <td><form:button type="submit" value="Modifier un commentaire"
                                                     class="button2">Modifier un commentaire</form:button></td>
                                </tr>
                            </div>
                        </c:if>

                    </table>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>

<%@include file="footer.jsp" %>

