package com.seyda.controller;

import com.seyda.dto.request.CompanyRequestDto;
import com.seyda.dto.response.CompanyResponseDto;
import com.seyda.repository.entity.Company;
import com.seyda.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyRestController {
    private final CompanyService companyService;



    @PostMapping("/add")
    public ResponseEntity<CompanyResponseDto> addDepartment(@RequestBody CompanyRequestDto dto){
        return ResponseEntity.ok(companyService.saveDepartment(dto));
    }
    @GetMapping("/save")
    public ResponseEntity<String> save(){

        companyService.save(
                Company.builder()
                        .companyName("Enoca")
                        .companyCode("12778")
                        .description("SAP consult")
                        .build()
        );
return ResponseEntity.ok("The company is succesfully saved ");
    }



}
