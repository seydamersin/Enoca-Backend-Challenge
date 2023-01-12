package com.seyda.service;

import com.seyda.dto.request.EmployeeRequestDto;
import com.seyda.dto.request.UpdateEmployeeRequestDto;
import com.seyda.dto.response.EmployeeResponseDto;
import com.seyda.mapper.IEmployeeMapper;
import com.seyda.repository.ICompanyRepository;
import com.seyda.repository.IEmployeeRepository;
import com.seyda.repository.entity.Company;
import com.seyda.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final ICompanyRepository companyRepository;
    private final IEmployeeRepository employeeRepository;

    public EmployeeResponseDto saveEmployee(EmployeeRequestDto dto) {

        Optional<Company> department = companyRepository.findById(dto.getCompanyId());

        Employee employee = IEmployeeMapper.INSTANCE.employeeFromEmployeeRequestDto(dto);
        employee.setCompany(department.get());
        employeeRepository.save(employee);

        EmployeeResponseDto employeeDto = IEmployeeMapper.INSTANCE
                .employeeResponseDtoFromEmployee(employee);

        employeeDto.setDepartmentName(employee.getCompany().getCompanyName());

        return employeeDto;

    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public void save(Employee employee) {

        employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeResponseDto> getAllEmployeesWithResponse() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponseDto> responseDtos = new ArrayList<>();

        for (Employee employee : employeeList) {
            responseDtos.add(
                    IEmployeeMapper.INSTANCE.employeeResponseDtoFromEmployee(employee)
            );
        }

        return responseDtos;
    }





    public void deleteById(Long id) {
        Optional<Employee>employee=employeeRepository.findById(id);
        if (employee.isPresent()){
            employeeRepository.deleteById(id);
        }else {
            System.out.println("employee don't found");
        }
    }

    public EmployeeResponseDto updateEmployee(UpdateEmployeeRequestDto dto) {
        Optional<Company> company = companyRepository.findById(dto.getDepartmentId());
        Employee employee = IEmployeeMapper.INSTANCE.employeeFromUpdateEmployeeRequestDto(dto);
        employee.setCompany(company.get());
        employeeRepository.save(employee);

        EmployeeResponseDto employeeDto = IEmployeeMapper.INSTANCE
                .employeeResponseDtoFromEmployee(employee);

        employeeDto.setDepartmentName(employee.getCompany().getCompanyName());

        return employeeDto;


    }
    public Company findEmployeeById(long id){
        Optional<Company> company=companyRepository.findById(id);
        if(company.isEmpty()){
            System.out.println("not found");

        }
        return company.get();
    }
    public String delete(long id){
        employeeRepository.deleteById(id);

        return "employee has been deleted..";



    }}