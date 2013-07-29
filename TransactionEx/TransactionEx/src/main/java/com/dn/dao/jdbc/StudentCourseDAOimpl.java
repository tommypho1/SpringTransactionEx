package com.dn.dao.jdbc;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.dn.dao.StudentCourseDAO;
import com.dn.domain.StudentCourse;

@Repository("studentCourseDAOimpl")
public class StudentCourseDAOimpl implements StudentCourseDAO{

	@Resource(name="dataSource")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource)
						 .withTableName("studentcoursetbl")
						 .usingGeneratedKeyColumns("numcourse");
		
		
	}
	
	public StudentCourse insertStudentCourse(StudentCourse studentCourse) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(studentCourse);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    
	    studentCourse.setNumCourse(newId.intValue());		
	    return studentCourse;
		
	}

}
