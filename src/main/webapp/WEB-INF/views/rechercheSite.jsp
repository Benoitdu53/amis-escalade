<%@ page contentType="text/html;charset=UTF-8" %>

<!-- Formulaire de critère de recherche des sites -->
<!-- Critère : Pays, département, type-->
<div class="container-fluid">

    <section>
        <div class="row">
            <div class="col-12">
                <div class="rechercheSites">
                    <form:form class="formulaireSite" method="get" action="searchSites">
                        <label>
                            <select name="pays">
                                <div class="button2">
                                    <option value="">Sélectionner un pays</option>
                                    <c:forEach var="pays" items="${pays}">
                                        <option value="${pays}" ${pays==param["pays"]?'selected="selected"':''}> ${pays}</option>
                                    </c:forEach>
                                </div>
                            </select>
                        </label>

                        <label>
                            <select name="departement">
                                <div class="button2">
                                    <option value="">Sélectionner un département</option>
                                    <c:forEach var="departement" items="${departement}">
                                    <option value="${departement}" ${departement==param["departement"]?'selected="selected"':''}> ${departement}</option>
                                    </c:forEach>
                            </select>
                        </label>

                        <label>
                            <select name="type">
                                <div class="button2">
                                    <option value="">Sélectionner un type</option>
                                    <c:forEach var="type" items="${type}">
                                        <option value="${type}" ${type==param["type"]?'selected="selected"':''}>${type}</option>
                                    </c:forEach>
                                </div>
                            </select>
                        </label>


                        <input class="button2" type="submit" value="Rechecher"/>
                    </form:form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <div class="rechercheSites">
                    <form:form class="formulaireSite" method="get" action="searchSitesSaisie">
                        <label for="saisie">Saisir un site</label>
                        <input id="saisie" type="text" name="saisie">

                        <input class="button2" type="submit" value="Rechercher">
                    </form:form>
                </div>
            </div>
        </div>
    </section>
</div>

<div class="clear"></div>