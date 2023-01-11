package com.seyda.mvc;

import com.seyda.repository.entity.Company;
import com.seyda.repository.entity.Employee;
import com.seyda.service.CompanyService;
import com.seyda.service.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @GetMapping("/list")
    public String listAll(Model model) {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        model.addAttribute("listEmployee", listEmployee);
        return "employees";
    }


    @GetMapping("/new")
    public String newEmployee(Model model) {
        List<Company> listCompany = companyService.getAllDepartments();
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        model.addAttribute("listDepartments", listCompany);

        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable(name = "id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("department", employee);

        return "department_form";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id){
        employeeService.deleteEmployeeById(id);

        return "redirect:/departments/list";
    }
}





