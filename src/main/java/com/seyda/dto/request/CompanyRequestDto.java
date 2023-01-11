package com.seyda.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CompanyRequestDto {

    private String CompanyName;

    private String description;

    private String CompanyCode;

}
