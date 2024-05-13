package com.ptit.Hirex.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@Builder
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

	@Column(name = "fullname", length = 100)
    private String firstName;
	
	@Column(name = "lastName", length = 100)
    private String lastName;

	@Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;
	
	@Column(name = "email", length = 100)
    private String email;

	@Column(name = "address", length = 200)
	private String address;
    
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
}