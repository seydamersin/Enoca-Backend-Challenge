package com.seyda.mvc;

import com.seyda.repository.entity.Company;
import com.seyda.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private  final CompanyService companyService;

    @GetMapping("/list")
    public String listAll(Model model) {
        List<Company> listCompany = companyService.getAllDepartments();
        model.addAttribute("listDepartment", listCompany);
        return "departments";
    }

    @GetMapping("/new")
    public String newCompany(Model model){
        Company company = new Company();
        model.addAttribute("department", company);

        return "department_form";
    }

    @PostMapping("/save")
    public String saveCompany(Company company) {
        companyService.save(company);

        return "redirect:/departments/list";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable(name = "id") Long id, Model model){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("department", company);

        return "department_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable(name = "id") Long id){
       companyService.deleteCompanyById(id);

        return "redirect:/departments/list";
    }
}
