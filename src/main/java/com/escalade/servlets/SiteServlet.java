package com.escalade.servlets;

import com.escalade.dao.SiteDaoImpl;
import com.escalade.dao.SiteEscalade;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
        (name = "SiteServlet",
        urlPatterns = "/site")
public class SiteServlet extends HttpServlet {

    private static final String VUE="/WEB-INF/site.jsp";

    // Injection de notre EJB ( Sessions Bean Stateless )
    @EJB
    private SiteDaoImpl siteDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Récuéperer les données de la BDD et les afficher à la vue site.jsp

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
