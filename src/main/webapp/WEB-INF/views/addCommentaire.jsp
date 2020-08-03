<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<head>
    <%@ include file="header.jsp"%>
</head>

<body>
<div id="formulaireCommentaire">
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
                    <td><form:input path="commentaire" required="required"/></td>
                </tr>
            </div>

            <div>
                <tr>
                    <td><button><a href="<c:url value="/sites"></c:url>">Retour</a></button></td>
                    <td><input type="submit" value="Ajouter un commentaire"/></td>
                </tr>
            </div>

        </table>
    </form:form>


</div>
</body>

<%@include file="footer.jsp"%>

