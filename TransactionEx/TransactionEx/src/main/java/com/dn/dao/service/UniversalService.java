package com.dn.dao.service;



import java.util.HashMap;

import com.dn.domain.Account;
import com.dn.domain.Student;
import com.dn.exceptions.ExceptionToTest;
import com.dn.exceptions.InValidCourseId;

public interface UniversalService {
	
	public Student insertStudentAndInsertStudentCourse(String studentName, String courseName) throws InValidCourseId;
	

	public void TransactionInsertAccount(Account account);
	
	public void TransactionInsertStudentCourseAccount(String studentName,String courseId, 
									Double totalMustPay, boolean signalExceptionForTest) throws ExceptionToTest;
	
}
