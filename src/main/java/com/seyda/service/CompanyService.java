package com.seyda.service;

import com.seyda.dto.request.CompanyRequestDto;
import com.seyda.dto.response.CompanyResponseDto;
import com.seyda.mapper.ICompanyMapper;
import com.seyda.repository.ICompanyRepository;
import com.seyda.repository.entity.Company;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CompanyService {
    private final ICompanyRepository companyRepository;


    public CompanyResponseDto saveDepartment(CompanyRequestDto dto) {

        Company company = ICompanyMapper.INSTANCE.companyFromCompanyRequestDto(dto);
        companyRepository.save(company);

        return ICompanyMapper.INSTANCE.companyResponseDtoFromCompany(company);
    }


    public List<Company> getAllDepartments() {
        return companyRepository.findAll();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).get();
    }

    public void deleteCompanyById(Long id) {

        companyRepository.deleteById(id);
    }

    public Company findbyId(Long id) {

        return companyRepository.findById(id).get();

    }

    public Boolean deleteDepartmentByIdWithResponse(Long id) {
        companyRepository.deleteById(id);
        return true;
    }


    public List<CompanyResponseDto> getAllCompanyWithResponse() {
        List<Company> companyList = companyRepository.findAll();
        List<CompanyResponseDto> responseDtos = new ArrayList<>();

        for (Company company : companyList) {
            responseDtos.add(
                    ICompanyMapper.INSTANCE.companyResponseDtoFromCompany(company)
            );
        }

        return responseDtos;
    }


}