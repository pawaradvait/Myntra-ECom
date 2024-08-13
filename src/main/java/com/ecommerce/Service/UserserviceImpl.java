package com.ecommerce.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.Repo.RolesRepo;
import com.ecommerce.Repo.UserRepo;
import com.ecommerce.entity.User;
import com.ecommerce.entity.UserRoles;

import jakarta.transaction.Transactional;

@Service
public class UserserviceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RolesRepo rolesRepo;

	 @Transactional
	    public User addUser(User user, Set<UserRoles> userRoles) throws Exception {
	        User existingUser = this.userRepo.findByUsername(user.getUsername());
	   User emailChecker = this.userRepo.findByEmail(user.getEmail());
	   if(emailChecker != null) {
		   System.out.println(emailChecker.getUsername());
	   }
	
if((this.userRepo.findByUsername(user.getUsername()) != null )&& (this.userRepo.findByEmail(user.getEmail())!=null)){
	        	throw new UsernameNotFoundException("username already exist");
	            } 
else if (emailChecker !=null) {
	throw new  UsernameNotFoundException("username already exist");              
	
	            } 
else if (this.userRepo.findByUsername(user.getUsername()) != null) {
	                throw new  UsernameNotFoundException("username already exist");
	            }
	        


	        // Save user first
	        User savedUser = this.userRepo.save(user);

	        // Set the saved user in UserRoles and save roles
	        for (UserRoles userRole : userRoles) {
	            userRole.setUser(savedUser);
	            this.rolesRepo.save(userRole.getRoles());
	        }

	        savedUser.setUserroles(userRoles);

	        // Save UserRoles
	        return this.userRepo.save(savedUser);
	    }
	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return this.userRepo.findAll();
	}

	@Override
	public User getUserbyId(Long id) {
		// TODO Auto-generated method stub
		return this.userRepo.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
	}

	@Override
	public void deleteUserbyId(Long id) {
		// TODO Auto-generated method stub
		this.userRepo.deleteById(id);
	}
	@Override
	public User findByEmail(String email) {
		
		return this.userRepo.findByEmail(email);
	}


}
