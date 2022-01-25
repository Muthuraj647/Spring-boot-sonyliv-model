package com.muthu.sampleProject.Sony_Live.UserService.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.muthu.sampleProject.Sony_Live.CustomException.ResourceNotFoundException;

import com.muthu.sampleProject.Sony_Live.Entity.Users;
import com.muthu.sampleProject.Sony_Live.SonyRepository.CentralRepository;
import com.muthu.sampleProject.Sony_Live.UserService.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private CentralRepository repo;
	
	
	//constructor
	public UserServiceImpl(CentralRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public void registerUsers(Users users) {
		
		//save on repository
		repo.save(users);
	}



	@Override
	public Users checkLogin(int id) {
		
		Users users= repo.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("User ", "Id", id));
		
		return users;
		
		
	}



	@Override
	public List<Users> listAllUser() {
		
		List<Users> list=repo.findAll();
		
		return list;
	}



	@Override
	public Users findUser(int id) {
		

		Users user= repo.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("User ", "Id", id));
		
		
		
		return user;
	}



	@Override
	public void updateUser(int id, Users users) {
		
		Users checkUser= repo.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("User ", "Id", id));
		
		checkUser.setName(users.getName());
		checkUser.setMobileNumber(users.getMobileNumber());
		checkUser.setEmailId(users.getEmailId());
		checkUser.setPassword(users.getPassword());
		
		repo.save(checkUser);
		
	}



	@Override
	public void deletUser(int id) {
		
		repo.deleteById(id);
		
	}


	//for movies table

}
