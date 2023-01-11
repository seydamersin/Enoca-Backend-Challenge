package com.seyda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CompanyResponseDto {


    private Long id;

    private String departmentCode;

    private String departmentName;

    private String description;
}
