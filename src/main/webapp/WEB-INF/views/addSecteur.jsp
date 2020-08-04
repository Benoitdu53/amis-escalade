<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<body>

    <div class="idForm">
        <h3>Ajouter un secteur</h3>
    </div>

    <div class="formulaire">
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
                        <td><button><a href="<c:url value="/sites"></c:url>"class="button2">Retour</a></button></td>
                        <td><input type="submit" value="Ajouter un secteur" class="button3"/></td>
                    </tr>
                </div>

            </table>
        </form:form>

    </div>
</body>

<%@ include file="footer.jsp"%>

