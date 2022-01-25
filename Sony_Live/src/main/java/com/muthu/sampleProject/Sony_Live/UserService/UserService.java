package com.muthu.sampleProject.Sony_Live.UserService;



import java.util.List;


import com.muthu.sampleProject.Sony_Live.Entity.Users;

public interface UserService {
	
	void registerUsers(Users users);
	
	//to check login
	
	Users checkLogin(int id); 
	
	//to view all users
	
	List<Users> listAllUser();
	
	//edit user
	
	Users findUser(int id);
	
	//update user
	
	void updateUser(int id, Users users);
	
	//delete user
	
	void deletUser(int id);
	
	
	
	//for movies table
	
	

}
