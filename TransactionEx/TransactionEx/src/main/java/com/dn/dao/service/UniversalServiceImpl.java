package com.dn.dao.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dn.dao.AccountDAO;
import com.dn.dao.StudentCourseDAO;
import com.dn.dao.StudentDAO;
import com.dn.domain.Account;
import com.dn.domain.Student;
import com.dn.domain.StudentCourse;
import com.dn.exceptions.ExceptionToTest;
import com.dn.exceptions.InValidCourseId;

@Repository("universalServiceImpl")
public class UniversalServiceImpl implements UniversalService{

	@Resource(name="studentDaoImpl")
	private StudentDAO studentDaoImpl;
	
	@Resource(name="studentCourseDAOimpl")
	private StudentCourseDAO studentCourseDAOimpl;
	
	@Resource(name="accountDAOimpl")
	private AccountDAO accountDAOimpl;
	
	@Transactional(rollbackFor={com.dn.exceptions.InValidCourseId.class})
	public Student insertStudentAndInsertStudentCourse(String studentName,String courseId) throws InValidCourseId {
		
		Student student = new Student();
		student.setStudentName(studentName);
		
		student = studentDaoImpl.insertStudent(student);
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudentId(student.getStudentid());
		
		if ((!(courseId.equals("CS100"))) && (!(courseId.equals("CS200"))))
			throw new InValidCourseId("Invalid CourseId Exception");
		
		studentCourse.setCourseId(courseId);
		
		studentCourseDAOimpl.insertStudentCourse(studentCourse);
		
		return student;
		
		
	}
	
	
	@Transactional
	public void TransactionInsertAccount(Account account) {
		accountDAOimpl.insertAccount(account);
		
	}


	@Transactional(rollbackFor={com.dn.exceptions.ExceptionToTest.class})
	public void TransactionInsertStudentCourseAccount(String studentName, String courseId,
					Double totalMustPay, boolean signalExceptionForTest) throws ExceptionToTest {
		
		
		Student student = new Student();
		try{
			student = insertStudentAndInsertStudentCourse(studentName, courseId);
		}
		catch (InValidCourseId e){}
		
		if (signalExceptionForTest==true)
			throw new ExceptionToTest("Exception to test");
		
		Account account = new Account();
		account.setStudentId(student.getStudentid());
		account.setTotalMustPay(totalMustPay);
		
		TransactionInsertAccount(account);
		
	}
}
	
	

