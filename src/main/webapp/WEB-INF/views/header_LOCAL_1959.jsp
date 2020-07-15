<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    </head>
    <body>
    <div class="sample-header">
        <div class="sample-header-section">
            <h1>Les amis de l'escalade</h1>
            <h2>Le site communautaire des amis de l'escalade</h2>
        </div>
    </div>

        <%--    Menu de navigation --%>
        <div class="navbar">
            <p><a href="/sites">Tout les sites </a> </p>
        </div>

    </body>
</html>
