package com.seyda.dto.response;

import com.seyda.repository.enums.Titles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Titles title;

    private String email;

    private String departmentName;


}
