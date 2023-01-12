package com.seyda.controller;

import com.seyda.dto.request.EmployeeRequestDto;
import com.seyda.dto.request.UpdateEmployeeRequestDto;
import com.seyda.dto.response.EmployeeResponseDto;

import com.seyda.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/employee")
public class EmployeeRestController {
    final private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeResponseDto> saveEmployee
            (@RequestBody EmployeeRequestDto dto){

        return ResponseEntity.ok(employeeService.saveEmployee(dto));



        }

        @GetMapping("/allemployees")
        public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
            return ResponseEntity.ok(employeeService.getAllEmployeesWithResponse());
        }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponseDto> updateEmployee
            (@RequestBody UpdateEmployeeRequestDto dto) {

        return ResponseEntity.ok(employeeService.updateEmployee(dto));
    }



        }
