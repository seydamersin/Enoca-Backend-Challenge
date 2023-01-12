package com.seyda.dto.request;

import com.seyda.repository.enums.Titles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequestDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Titles title;

    private String email;

    private Long departmentId;


}
