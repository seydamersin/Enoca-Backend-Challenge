package com.seyda.mapper;

import com.seyda.dto.request.CompanyRequestDto;
import com.seyda.dto.response.CompanyResponseDto;
import com.seyda.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyMapper {
    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);


    Company companyFromCompanyRequestDto(final CompanyRequestDto dto);

    CompanyResponseDto companyResponseDtoFromCompany(final Company company);
}
