package com.seyda.mapper;

import com.seyda.dto.request.EmployeeRequestDto;
import com.seyda.dto.response.EmployeeResponseDto;
import com.seyda.repository.entity.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-10T23:29:55+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IEmployeeMapperImpl implements IEmployeeMapper {

    @Override
    public Employee employeeFromEmployeeRequestDto(EmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.firstName( dto.getFirstName() );
        employee.lastName( dto.getLastName() );
        employee.title( dto.getTitle() );
        employee.email( dto.getEmail() );

        return employee.build();
    }

    @Override
    public EmployeeResponseDto employeeResponseDtoFromEmployee(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponseDto.EmployeeResponseDtoBuilder employeeResponseDto = EmployeeResponseDto.builder();

        employeeResponseDto.id( employee.getId() );
        employeeResponseDto.firstName( employee.getFirstName() );
        employeeResponseDto.lastName( employee.getLastName() );
        employeeResponseDto.title( employee.getTitle() );
        employeeResponseDto.email( employee.getEmail() );

        return employeeResponseDto.build();
    }
}
