package com.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails{
 
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
 
//	@Embedded
//	@ElementCollection
//	@CollectionTable(name="paymentInfo",joinColumns=@JoinColumn(name="user_id"))
//	private List<PaymentInformation> paymentInfo = new ArrayList<>();
// 
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
//	@JsonIgnore
//	private List<Rating> rating = new ArrayList<>();
//  
//	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
//	@JsonIgnore
//	private List<Review> review = new ArrayList<>();
   
	private LocalDateTime date;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	  @JsonIgnore
		private Set<UserRoles> userroles = new HashSet<>();

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Authority> set = new HashSet<>();
		 
		this.userroles.forEach(userrole->{
			set.add( new Authority( userrole.getRoles().getRoleName()));
		});
		
		
		return set;
	}

	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Orderss> orderitem = new ArrayList<>();
		
	
	
}

