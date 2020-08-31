package com.stonks.userservice.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	private String username;
	private String userType;
	private String email;
	private String mobileNumber;
	private boolean confirmed;
}
