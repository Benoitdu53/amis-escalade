<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ include file="header.jsp"%>
</head>

<body>
<div id="formulaireVoie">
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
                    <td><button><a href="<c:url value="/sites"></c:url>">Retour</a></button></td>
                    <td><input type="submit" value="Ajouter une voie"/></td>
                </tr>
            </div>
        </table>
    </form:form>
</div>
</body>