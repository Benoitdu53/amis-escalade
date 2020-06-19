<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>

</head>

<body>
<div id="formulaireLongueur">
    <%--@elvariable id="longueur" type="com.escalade.model.Longueur"--%>
    <form:form id="formulaireLongueur" method="post" modelAttribute="longueur">
        <table>
            <div class="longRelais">
                <tr>
                    <td><form:label id="longRelais" class="col-md-3 control-label" path="longRelais">Longueur des relais</form:label></td>
                    <td><form:input path="longRelais"/></td>
                </tr>
            </div>

            <div class="longTotal">
                <tr>
                    <td><form:label id="longTotal" class="col-md-3 control-label" path="longTotal">Longueur total de la voie</form:label></td>
                    <td><form:input path="longTotal"/></td>
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