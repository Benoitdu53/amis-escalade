<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

<!DOCTYPE html>
<html>
    <body>

        <p><a href="sites">Tout les sites </a> </p>

        <!-- Formulaire de critère de recherche des sites -->
        <form id="formulaireSite" method="get" action="sites">
            <div id="pays">
                <select name="pays" id="listePays">
                    <option value="">Sélectionner un pays</option>

                        <option value="testPays">En test</option>

                </select>
            </div>

            <div id="departement">
                <select name="departement"id="listeDepartement">
                    <option value="">Sélectionner un département</option>

                        <option value="testDepartement">En test</option>

                </select>
            </div>

                <!-- Par nom -->
                    <select name="nom">
                            <option value="">Sélectionner le nom du site</option>
                        <c:forEach var="sites" items="${sites}">
                                <option value="${sites.nom}">${sites.nom}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <input type="submit" value="submit"/>
        </form>

        <script>
            jQuery(document).ready(function () {
                /* Au lancement on cache le bloc "departement" */
                $("div#departement").hide();
                /* Au clic sur un pays on affiche les départements */
                jQuery('input[name=listeDepartement]:selected').onclick(function () {
                    $("div#listeDepartement").show();
                })
            })
        </script>
    </body>
</html>