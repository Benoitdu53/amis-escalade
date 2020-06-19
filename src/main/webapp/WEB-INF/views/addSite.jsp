<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
    <form:form id="formualireSite" method="post" action="/addSite" modelAttribute="site">
    <table>
        <div class="nom">
            <tr>
                <td><form:label id="nom" class="col-md-3 control-label" path="nom">Nom du site</form:label></td>
                <td><form:input path="nom"/></td>
            </tr>
        </div>
        
        <div class="departement">
            <tr>
                <td><form:label id="departement" class="col-md-3 control-label" path="departement">Département du site</form:label></td>
                <td><form:input path="departement"/></td>
            </tr>
        </div>

        <div class="pays">
            <tr>
                <td><form:label id="pays" class="col-md-3 control-label" path="pays">Pays du site</form:label></td>
                <td><form:input path="pays"/></td>
            </tr>
        </div>

        <div class="nbreSecteur">
            <tr>
                <td><form:label id="nbreSecteur" class="col-md-3 control-label" path="nbreSecteur">Nombre de secteur</form:label></td>
                <td><form:input path="nbreSecteur"/></td>
            </tr>
        </div>

        <div id="type">
            <form:select name="type" path="type">
                    <option value="Falaise">Falaise</option>
                    <option value="Bloc">Bloc</option>
            </form:select>
        </div>

        <div class="cotationMin">
            <tr>
                <td><form:label id="cotationMin" class="col-md-3 control-label" path="cotationMin">Cotation minimum du site</form:label></td>
                <td><form:input path="cotationMin"/></td>
            </tr>
        </div>

        <div class="cotationMax">
            <tr>
                <td><form:label id="cotationMax" class="col-md-3 control-label" path="cotationMax">Cotation maximum du site</form:label></td>
                <td><form:input path="cotationMax"/></td>
            </tr>
        </div>

        <div class="longueurMax">
            <tr>
                <td><form:label id="longueurMax" class="col-md-3 control-label" path="longueurMax">Longueur maximum du site</form:label></td>
                <td><form:input path="longueurMax"/></td>
            </tr>
        </div>

        <div>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </div>
    </table>
    </form:form>

</body>

