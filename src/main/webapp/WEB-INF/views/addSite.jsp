    <%@include file="header.jsp"%>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

<body>

    <div class="idForm">
        <h3>Ajouter un site</h3>
    </div>

    <div class="formulaire">
    <form:form id="formulaireSite" method="post" action="/addSite" modelAttribute="site">
    <table>
        <div class="nomSite">
            <tr>
                <td><form:label id="nomSite" class="col-md-3 control-label" path="nom">Nom du site</form:label></td>
                <td><form:input path="nom" required="required"/></td>
            </tr>
        </div>
        
        <div class="departement">
            <tr>
                <td><form:label id="departement" class="col-md-3 control-label" path="departement">Département du site</form:label></td>
                <td><form:input path="departement" required="required"/></td>
            </tr>
        </div>

        <div class="pays">
            <tr>
                <td><form:label id="pays" class="col-md-3 control-label" path="pays">Pays du site</form:label></td>
                <td><form:input path="pays" required="required"/></td>
            </tr>
        </div>

        <div id="type">
            <tr>
                <td><form:label id="type" class="col-md-3 control-label" path="type">Type du site</form:label></td>
                <td><form:select name="type" path="type">
                        <option value="Falaise">Falaise</option>
                        <option value="Bloc">Bloc</option>
                </form:select></td>
            </tr>
        </div>

        <div class="cotationMin">
            <tr>
                <td><form:label id="cotationMin" class="col-md-3 control-label" path="cotationMin">Cotation minimum du site</form:label></td>
                <td><form:select name="cotationMin" path="cotationMin">
                        <option value="3a">3a</option><option value="3b">3b</option><option value="3c">3c</option>
                        <option value="4a">4a</option><option value="4b">4b</option><option value="4c">4c</option>
                        <option value="5a">5a</option><option value="5b">5b</option><option value="5c">5c</option>
                        <option value="6a">6a</option><option value="6b">6b</option><option value="6c">6c</option>
                        <option value="7a">7a</option><option value="7b">7b</option><option value="7c">7c</option>
                        <option value="8a">8a</option><option value="8b">8b</option><option value="8c">8c</option>
                        <option value="9a">9a</option><option value="9b">9b</option><option value="9c">9c</option>
                </form:select></td>
            </tr>
        </div>

        <div class="cotationMax">
            <tr>
                <td><form:label id="cotationMax" class="col-md-3 control-label" path="cotationMax">Cotation maximum du site</form:label></td>
                <td><form:select name="cotationMax" path="cotationMax">
                        <option value="3a">3a</option><option value="3b">3b</option><option value="3c">3c</option>
                        <option value="4a">4a</option><option value="4b">4b</option><option value="4c">4c</option>
                        <option value="5a">5a</option><option value="5b">5b</option><option value="5c">5c</option>
                        <option value="6a">6a</option><option value="6b">6b</option><option value="6c">6c</option>
                        <option value="7a">7a</option><option value="7b">7b</option><option value="7c">7c</option>
                        <option value="8a">8a</option><option value="8b">8b</option><option value="8c">8c</option>
                        <option value="9a">9a</option><option value="9b">9b</option><option value="9c">9c</option>
                    </form:select></td>
            </tr>
        </div>

        <div class="descriptionSite">
            <tr>
                <td><form:label id="descriptionSite" class="col-md-3 control-label" path="description">Description du site</form:label></td>
                <td><form:input path="description"/></td>
            </tr>
        </div>

        <br>

        <div>
            <tr>
                <td><input type="submit" value="Ajouter un site" class="button2"/></td>
            </tr>
        </div>
    </table>
    </form:form>
    </div>

</body>

<%@include file="footer.jsp"%>

