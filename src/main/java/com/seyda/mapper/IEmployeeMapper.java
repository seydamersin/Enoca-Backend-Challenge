package com.seyda.mapper;

import com.seyda.dto.request.EmployeeRequestDto;
import com.seyda.dto.request.UpdateEmployeeRequestDto;
import com.seyda.dto.response.EmployeeResponseDto;
import com.seyda.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper {

    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee employeeFromEmployeeRequestDto(final EmployeeRequestDto dto);

    EmployeeResponseDto employeeResponseDtoFromEmployee(final Employee employee);

    Employee employeeFromUpdateEmployeeRequestDto(final UpdateEmployeeRequestDto dto);
}
