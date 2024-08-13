package com.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id
	private Long roleId;
	private String roleName;
	
	@OneToMany(mappedBy="roles",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<UserRoles> userroles = new HashSet<>();
	
}
