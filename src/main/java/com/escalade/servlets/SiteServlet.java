package com.escalade.servlets;

import com.escalade.dao.ISiteDao;
import com.escalade.dao.SiteDaoImpl;
import org.hibernate.service.spi.InjectService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SiteServlet", urlPatterns = "/site")
public class SiteServlet extends HttpServlet {

    private static final String VUE="/WEB-INF/site.jsp";
    private static final String SITES ="sites";

    // Injection de notre EJB ( Sessions Bean Stateless )
    @Inject
    private ISiteDao siteDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println(siteDao);
        request.setAttribute(SITES,siteDao.listSite());

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
