package com.dn.dao.test;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dn.dao.service.UniversalService;
import com.dn.domain.Student;
import com.dn.exceptions.InValidCourseId;

@ContextConfiguration("app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUniversalServiceImpl {
	
	@Resource(name="universalServiceImpl")
	private UniversalService universalServiceImpl;
	

	@Test(expected = InValidCourseId.class)  
	public void testInsertStudent() throws InValidCourseId{
		
		universalServiceImpl.insertStudentAndInsertStudentCourse("Tony", "S100");
		int i=1;
		assertTrue(i==1);
	}

}
