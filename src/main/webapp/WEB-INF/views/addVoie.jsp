<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div id="formulaireVoie">
    <%--@elvariable id="voie" type="com.escalade.model.Voie"--%>
    <form:form id="formulaireVoie" method="post" modelAttribute="voie">
        <table>
            <div class="voie">
                <tr>
                    <td><form:label id="voie" class="col-md-3 control-label" path="voie">Lettre de la voie</form:label></td>
                    <td><form:input path="voie"/></td>
                </tr>
            </div>

            <div class="longueur">
                <tr>
                    <td><form:label id="longueur" class="col-md-3 control-label" path="longueur">Longueur de la voie</form:label></td>
                    <td><form:input path="longueur"/></td>
                </tr>
            </div>

            <div class="cotation">
                <tr>
                    <td><form:label id="cotation" class="col-md-3 control-label" path="cotation">Cotation de la voie</form:label></td>
                    <td><form:input path="cotation"/></td>
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