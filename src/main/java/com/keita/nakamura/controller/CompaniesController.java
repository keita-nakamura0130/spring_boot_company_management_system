package com.keita.nakamura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keita.nakamura.entity.Company;
import com.keita.nakamura.mapper.CompanyMapper;

@Controller
public class CompaniesController {
    
    @Autowired
    CompanyMapper CompanyMapper;
    
    /**
     * 会社一覧
     */
    @RequestMapping(value = "/companies/index")
    public String index(Model model) {
        List<Company> companies = CompanyMapper.findAll();
        model.addAttribute("companies", companies);
        
        return "/companies/index";
    }
}
