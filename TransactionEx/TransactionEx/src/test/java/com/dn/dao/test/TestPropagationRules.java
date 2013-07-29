package com.dn.dao.test;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dn.dao.service.UniversalService;
import com.dn.exceptions.ExceptionToTest;
import com.dn.exceptions.InValidCourseId;

@ContextConfiguration("app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPropagationRules {

	@Resource(name="universalServiceImpl")
	private UniversalService universalServiceImpl;
	

	@Test
	public void testTransactionInsertStudentCourseAccount() throws ExceptionToTest{
		
		universalServiceImpl.TransactionInsertStudentCourseAccount("Tony", "CS100", 1000.0, true);
		int i=1;
		assertTrue(i==1);
	}
}
