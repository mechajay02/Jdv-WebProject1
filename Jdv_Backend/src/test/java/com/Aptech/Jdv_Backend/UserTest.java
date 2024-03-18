package com.Aptech.Jdv_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Aptech.Jdv_Backend.DAO.UserDAO;
import com.Aptech.Jdv_Backend.modal.User;

public class UserTest
{

	private static AnnotationConfigApplicationContext context;
	static User user;
	static UserDAO userDAO;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.jadavpur_E_Backend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testInsert()
	{
		user = new User();
		
//		user.setContactNumber("82090927346");
//		user.setEmail("sachin@gmail.com");
//		user.setEnabled(true);
//		user.setFirstName("Sachin");
//		
//		user.setLastName("Roy");
//		user.setPassword("user12342");
//		user.setRole("USER");
		
		
		user.setContactNumber("7044756675");
		user.setEmail("bhatiarajiv@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Rajiv");
		user.setLastName("Bhatia");
		user.setPassword("supplier12345");
		user.setRole("SUPPLIER");
		
		
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
	}
	
	//@Test
	public void testGetUser()
	{
		user = userDAO.getUser("rohan@gmail.com");
		assertEquals("Error fetching user" , "Rohan" , user.getFirstName());
	}


}
