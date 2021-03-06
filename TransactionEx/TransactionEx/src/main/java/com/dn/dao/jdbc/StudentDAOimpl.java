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

import com.dn.dao.StudentDAO;
import com.dn.domain.Student;

@Repository("studentDaoImpl")
public class StudentDAOimpl implements StudentDAO
{
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
						 .withTableName("studenttbl")
						 .usingGeneratedKeyColumns("studentid");
		
		
	}
	
	public Student insertStudent(Student student) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(student);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    
	    student.setStudentid(newId.intValue());		
	    return student;
		
	}

}
