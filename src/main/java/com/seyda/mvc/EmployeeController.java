package com.seyda.mvc;

import com.seyda.dto.request.EmployeeRequestDto;
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
        model.addAttribute("companyList", listCompany);

        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(EmployeeRequestDto employeeModel) {
        Company company=companyService.findbyId(employeeModel.getCompanyId());
        employeeService.save(Employee.builder()
                .company(company)
                .email(employeeModel.getEmail())
                .firstName(employeeModel.getFirstName())
                .lastName(employeeModel.getLastName())
                .title(employeeModel.getTitle())
                .build());



        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable(name = "id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        List<Company> listCompany = companyService.getAllDepartments();
        model.addAttribute("employee", employee);
        model.addAttribute("companyList", listCompany);

        return "employee_form";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id){
        employeeService.deleteEmployeeById(id);

        return "redirect:/employee/list";
    }
}






