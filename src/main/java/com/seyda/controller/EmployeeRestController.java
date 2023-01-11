package com.seyda.controller;

import com.seyda.dto.request.CompanyRequestDto;
import com.seyda.dto.request.EmployeeRequestDto;
import com.seyda.dto.response.CompanyResponseDto;
import com.seyda.dto.response.EmployeeResponseDto;
import com.seyda.repository.entity.Employee;
import com.seyda.service.CompanyService;
import com.seyda.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeRestController {
    final private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDto> addDepartment
            (@RequestBody EmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.saveEmployee(dto));
    }
    public void save(){
        System.out.println("Employee has succesfully saved");
        employeeService.save(
                Employee.builder()
                        .firstName("seyda")
                        .lastName("mersin")
                        .email("mersinseyda@gmail.com")

                .build()
        );
    }


}
