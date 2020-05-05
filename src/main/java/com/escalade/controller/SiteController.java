package com.escalade.controller;

import com.escalade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "/sites")
    public String findSites(Model model){
        model.addAttribute("sites", siteService.getSites());
        return "sites";
    }

}
