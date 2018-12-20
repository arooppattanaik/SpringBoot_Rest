package com.project.Spring.rest.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {


	private static List<User> users = new ArrayList<>();

	private static int UserCount=3;
	
	static {
		users.add(new User(1, "Radha", new Date()));
		users.add(new User(2, "Rashmi", new Date())); 
		users.add(new User(3, "Anjali", new Date()));
	}
	
	public List<User> findAll(){
		
		return users;
	}
	
	public User saveUser(User user){
		if(user.getId()==null){
			user.setId(++UserCount);
		}
		users.add(user);
		return user;
	}
	
	public User findUser(int id){
		for(User us: users){
			if(us.getId()==id){
				return us;	
			}
		}
		
		return null;
	}
}