package com.Aptech.Jdv_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Aptech.Jdv_Backend.DAO.CategoryDAO;
import com.Aptech.Jdv_Backend.modal.Category;

public class CategoryTest 
{
	private static AnnotationConfigApplicationContext context;
	static Category category;
	static CategoryDAO categoryDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Aptech.Jdv_Backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
	public void testInsert()
	{
		category = new Category();
		//category.setId(12);
		category.setCategoryName("TV");
		category.setDescription("Sample category for TV");
		category.setActive(true);
		
		assertEquals("Error adding Category" , true, categoryDAO.insert(category));
	}
	
//	@Test
	public void testDelete()
	{
		category = categoryDAO.getCategory(3);
		
		assertEquals("Error deleting Category" , true, categoryDAO.delete(category));
	}
	
//	@Test
	public void testUpdate()
	{
		category = categoryDAO.getCategory(3);
		category.setCategoryName("HomeTheatre");
		
		assertEquals("Error updating Category" , true, categoryDAO.update(category));
	}
	
	@Test
	public void testCategoryList()
	{
		assertEquals("Error updating Category" , 3, categoryDAO.categoryList().size());
	}
}
