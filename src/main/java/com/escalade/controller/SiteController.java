package com.escalade.controller;

import com.escalade.model.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServlet;


@Controller
@RequestMapping("/site")
public class SiteController extends HttpServlet {

    @Autowired
    SiteEscalade siteEscalade;

    @RequestMapping(value = "/getAllSites", method = RequestMethod.GET)
    public String GetAllSites(Model model){
        return "siteDisplay";
    }
}
