package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

//this is a bean that is managed by Spring
@Component
public class UserDaoService {
	public static List<User> users = new ArrayList<>();
	
	//the ID is the same as what number in the list it is
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	//Finds all the users
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user)
	{
		//if it does not have an ID
		if(user.getId()==null)
		{
			user.setId(usersCount++);
		}
		users.add(user);
		return user;
	}
	
	//finds a specific user in the arraylist
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User deleteByID(int id)
	{
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext())
		{
			User user = iterator.next();
			if(user.getId() == id)
			{
				iterator.remove();
				return user;
			}
		}
		return null;
	}

	
}
