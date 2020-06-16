<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>

</head>

<body>
<div id="formulaireSecteur">
    <form:form id="formulaireSecteur" method="post" modelAttribute="secteur">
        <table>
            <div class="secteur">
                <tr>
                    <td><form:label id="secteur" class="col-md-3 control-label" path="secteur">Numéro du secteur</form:label></td>
                    <td><form:input path="secteur"/></td>
                </tr>
            </div>

            <div class="nbreVoie">
                <tr>
                    <td><form:label id="nbreVoie" class="col-md-3 control-label" path="nbreVoie">Nombre de voies du secteur</form:label></td>
                    <td><form:input path="nbreVoie"/></td>
                </tr>
            </div>

            <div>
                <tr>
                    <td><button value="<c:url value="site/${idSite}"></c:url> ">Retour</button> </td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </div>
        </table>
    </form:form>
</div>
</body>
