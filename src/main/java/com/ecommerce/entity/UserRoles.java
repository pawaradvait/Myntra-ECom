package com.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRoles {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userRoleid;

	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role roles;
}
