package com.seyda.dto.request;

import com.seyda.repository.enums.Titles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeRequestDto {
    private String firstName;

    private String lastName;

    private Titles title;

    private String email;

    private Long CompanyId;

}
