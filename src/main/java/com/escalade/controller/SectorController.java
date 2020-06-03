package com.escalade.controller;

import com.escalade.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SectorController
{

    @Autowired
    private SectorService sectorService;

    @RequestMapping(value = "site", method = RequestMethod.GET)
    public String findSector(Model model){

        model.addAttribute("secteurs", sectorService.getAllSector());

        return "/site";
    }
}
