package com.escalade.configuration;

import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthentificationFilter implements Filter
{

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        String pseudo = (String) httpSession.getAttribute("pseudo");
        String url = httpServletRequest.getServletPath();

        if ((url.startsWith("/topos") || url.startsWith("/profil")) && pseudo == null){
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("loginUtilisateur");
            return;
        }

        // Continue le traitement
        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }
}
