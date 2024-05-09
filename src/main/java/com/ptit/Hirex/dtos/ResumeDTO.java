package com.ptit.Hirex.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDTO {

	    private Long id;
	    private String nameFile;
	    private String fileBase64;
	    private Long employerId; 
	    
	

}