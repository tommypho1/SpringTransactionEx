package com.dn.dao.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.dn.dao.StudentDAO;
import com.dn.domain.Student;

@ContextConfiguration("app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentDAOimplTest {
	
	@Resource(name="studentDaoImpl")
	private StudentDAO stDAO;
	
	
	

	@Test
	public void testInsertStudent(){
		Student st = new Student();
		st.setStudentid(0);
		st.setStudentName("Tony");
		st = stDAO.insertStudent(st);
		int i=1;
		assertTrue(i==1);
	}
	
}
