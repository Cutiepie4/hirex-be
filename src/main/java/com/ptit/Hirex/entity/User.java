package com.ptit.Hirex.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "fullname", length = 100)
    private String fullName;

    @Column(name = "address", length = 200)
    private String address;
    
	@Column(name = "phone_number", length = 10, nullable = false)
	private String phoneNumber;

	@Column(name = "password", length = 200, nullable = false)
	private String password;
	
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

	@Column(name = "is_active")
	private boolean active;

	@Column(name = "facebook_account_id")
	private int facebookAccountId;

	@Column(name = "google_account_id")
	private int googleAccountId;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	//Lấy ra các quyền
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_" + getRole().getName().toUpperCase()));
		// authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authorityList;
	}

	@Override
	public String getUsername() {
		return phoneNumber;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
