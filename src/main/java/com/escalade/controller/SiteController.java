package com.escalade.controller;

import com.escalade.model.SiteEscalade;
import com.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.enterprise.inject.Model;
import java.util.List;

@Controller
@RequestMapping("site")
public class SiteController {

    @Autowired
    private ISiteService iSiteService;

    @GetMapping("/sites")
    public String GetAllSites(Model model){
        List<SiteEscalade> siteEscalades = ISiteService.getAllSites();
        model.addAttribute("site", siteEscalades);
        return "siteDisplay";
    }
}
