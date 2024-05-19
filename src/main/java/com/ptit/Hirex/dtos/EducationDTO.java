package com.ptit.Hirex.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationDTO {
    private Long id;
    private String level;
    private String institution;
    private String major; 
    private String description;
    private String startDate;
    private String endDate;
    private Long employeeId; 
}