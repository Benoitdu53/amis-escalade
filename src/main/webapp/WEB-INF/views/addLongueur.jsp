<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<%@ include file="header.jsp"%>

<body>

    <div class="idForm">
        <h3>Ajouter une longueur</h3>
    </div>

    <div class="formulaire">
    <%--@elvariable id="longueur" type="com.escalade.model.Longueur"--%>
    <form:form id="formulaireLongueur" method="post" modelAttribute="longueur">
        <table>
            <div class="nbrePoints">
                <tr>
                    <td><form:label id="nbrePoints" class="col-md-3 control-label" path="nbrePoints">Indiquer le nombre de points</form:label></td>
                    <td><form:input path="nbrePoints" required="required" type="number" min="0" max="100"/></td>
                </tr>
            </div>

            <div class="taille">
                <tr>
                    <td><form:label id="taille" class="col-md-3 control-label" path="taille">Indiquer la taille</form:label></td>
                    <td><form:input path="taille" required="required" type="number" min="0" max="1000"/></td>
                </tr>
            </div>

            <div class="cotation">
                <tr>
                    <td>
                        <form:label id="cotation" class="col-md-3 control-label" path="cotation">Cotation de la longueur</form:label>
                        <form:select name="cotation" path="cotation">
                            <option value="3a">3a</option><option value="3b">3b</option><option value="3c">3c</option>
                            <option value="4a">4a</option><option value="4b">4b</option><option value="4c">4c</option>
                            <option value="5a">5a</option><option value="5b">5b</option><option value="5c">5c</option>
                            <option value="6a">6a</option><option value="6b">6b</option><option value="6c">6c</option>
                            <option value="7a">7a</option><option value="7b">7b</option><option value="7c">7c</option>
                            <option value="8a">8a</option><option value="8b">8b</option><option value="8c">8c</option>
                            <option value="9a">9a</option><option value="9b">9b</option><option value="9c">9c</option>
                        </form:select>
                    </td>
                </tr>
            </div>

            <div>
                <tr>
                    <td><button><a href="<c:url value="/sites"></c:url>" class="button3">Retour</a></button></td>
                    <td><input type="submit" value="Ajouter une longueur" class="button2"/></td>
                </tr>
            </div>
        </table>
    </form:form>
    </div>
</body>

<%@ include file="footer.jsp"%>