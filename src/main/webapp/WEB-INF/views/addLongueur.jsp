<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <jsp:include page="include/header.jsp"></jsp:include>
</head>

<body>
<div id="formulaireLongueur">
    <%--@elvariable id="longueur" type="com.escalade.model.Longueur"--%>
    <form:form id="formulaireLongueur" method="post" modelAttribute="longueur">
        <table>
            <div class="nbrePoints">
                <tr>
                    <td><form:label id="nbrePoints" class="col-md-3 control-label" path="nbrePoints">Indiquer le nombre de points</form:label></td>
                    <td><form:input path="nbrePoints"/></td>
                </tr>
            </div>

            <div class="taille">
                <tr>
                    <td><form:label id="taille" class="col-md-3 control-label" path="taille">indiquer la taille</form:label></td>
                    <td><form:input path="taille"/></td>
                </tr>
            </div>

            <div class="cotation">
                <tr>
                    <td><form:label id="cotation" class="col-md-3 control-label" path="cotation">Indiquer la cotation</form:label></td>
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