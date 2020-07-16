<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ include file="../header.jsp"%>
</head>

<body>
<div id="formulaireSecteur">
    <form:form id="formulaireSecteur" method="post" modelAttribute="secteur">
        <table>
            <div class="nomSecteur">
                <tr>
                    <td><form:label id="nomSecteur" class="col-md-3 control-label" path="nom">Nom du secteur</form:label></td>
                    <td><form:input path="nom" required="required"/></td>
                </tr>
            </div>

            <div class="descriptionSecteur">
                <tr>
                    <td><form:label id="descriptionSecteur" class="col-md-3 control-label" path="description">Description du secteur</form:label></td>
                    <td><form:input path="description" required="required"/></td>
                </tr>
            </div>

            <div>
                <tr>
                    <td><button value="<c:url value="/site/${idSite}"></c:url> ">Retour</button> </td>
                    <td><input type="submit" value="Ajouter un secteur"/></td>
                </tr>
            </div>
        </table>
    </form:form>
</div>
</body>
