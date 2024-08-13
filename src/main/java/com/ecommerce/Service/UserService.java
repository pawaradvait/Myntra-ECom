package com.ecommerce.Service;

import java.util.List;
import java.util.Set;

import com.ecommerce.entity.User;
import com.ecommerce.entity.UserRoles;



public interface UserService {

User addUser(User user,Set<UserRoles> userroles ) throws Exception;
	List<User> getallUser();
	User getUserbyId(Long id);
	User updateUser(User user);
	void deleteUserbyId(Long id);
 
	User findByEmail(String email);
}
