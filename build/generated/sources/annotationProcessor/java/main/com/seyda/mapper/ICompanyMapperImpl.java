package com.seyda.mapper;

import com.seyda.dto.request.CompanyRequestDto;
import com.seyda.dto.response.CompanyResponseDto;
import com.seyda.repository.entity.Company;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T13:41:50+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICompanyMapperImpl implements ICompanyMapper {

    @Override
    public Company companyFromCompanyRequestDto(CompanyRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.companyName( dto.getCompanyName() );
        company.description( dto.getDescription() );
        company.companyCode( dto.getCompanyCode() );

        return company.build();
    }

    @Override
    public CompanyResponseDto companyResponseDtoFromCompany(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponseDto.CompanyResponseDtoBuilder companyResponseDto = CompanyResponseDto.builder();

        companyResponseDto.id( company.getId() );
        companyResponseDto.description( company.getDescription() );

        return companyResponseDto.build();
    }
}
