<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<body>

    <form:form id="addSite" method="post" action="/addSites">

        <div class="nom">
            <label id="nom" class="col-md-3 control-label">Nom du site</label>
        </div>
        <div class="departement">
            <label id="departement" class="col-md-3 control-label">Département du site</label>
        </div>

        <div class="pays">
            <label id="pays" class="col-md-3 control-label">Pays du site</label>
        </div>

        <div class="nbreSecteur">
            <label id="nbreSecteur" class="col-md-3 control-label">Nombre secteur du site</label>
        </div>

        <select name="type">
            <div id="type">
                <option value="Falaise">Falaise</option>
                <option value="Bloc">Bloc</option>
            </div>
        </select>

        <div class="cotationMin">
            <label id="cotationMin" class="col-md-3 control-label">Cotation minimum du site</label>
        </div>

        <div class="cotationMax">
            <label id="cotationMax" class="col-md-3 control-label">Cotation maximum du site</label>
        </div>

        <div class="longueurMax">
            <label id="longueurMax" class="col-md-3 control-label">Longueur maximum du site</label>
        </div>

    </form:form>

</body>

