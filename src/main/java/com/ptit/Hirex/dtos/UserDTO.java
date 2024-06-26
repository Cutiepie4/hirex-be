package com.ptit.Hirex.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
    @JsonProperty("fullname")
    private String fullName;
	
	@JsonProperty("phone_number")
	@NotBlank(message = "Phone number is required")
	private String phoneNumber;

	@NotBlank(message = "Password cannot be blank")
	private String password;

	@JsonProperty("retype_password")
	private String retypePassword;
	
    private String address;

    private String mail;
    
    private String gender;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;
	
	@JsonProperty("facebook_account_id")
	private int facebookAccountId;

	@JsonProperty("google_account_id")
	private int googleAccountId;

	@NotNull(message = "Role ID is required")
	@JsonProperty("role_id")
	private Long roleId;
	
}
