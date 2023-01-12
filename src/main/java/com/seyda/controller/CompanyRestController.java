package com.seyda.controller;

import com.seyda.dto.request.CompanyRequestDto;
;
import com.seyda.dto.response.CompanyResponseDto;

import com.seyda.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/company")
public class CompanyRestController {
    private final CompanyService companyService;



    @PostMapping("/save")
    public ResponseEntity<CompanyResponseDto> saveDepartment(@RequestBody CompanyRequestDto dto) {
        return ResponseEntity.ok(companyService.saveDepartment(dto));
    }

    @GetMapping("/alldepartments")
    public ResponseEntity<List<CompanyResponseDto>> getAllDepartments(){
        return ResponseEntity.ok(companyService.getAllCompanyWithResponse());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyResponseDto> updateDepartment
            (@PathVariable Long id, @RequestBody CompanyRequestDto dto) {

        return ResponseEntity.ok(companyService.saveDepartment(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteDepartment(@RequestBody Long id) {
        return ResponseEntity.ok(companyService.deleteDepartmentByIdWithResponse(id));
    }

}