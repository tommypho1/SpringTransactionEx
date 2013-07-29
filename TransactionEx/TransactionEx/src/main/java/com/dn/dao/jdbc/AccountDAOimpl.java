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

import com.dn.dao.AccountDAO;
import com.dn.domain.Account;

@Repository("accountDAOimpl")
public class AccountDAOimpl implements AccountDAO {
	
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
						 .withTableName("accounttbl")
						 .usingGeneratedKeyColumns("accountid");
		
		
	}

	public Account insertAccount(Account account) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(account);
	    Number newId = jdbcInsert.executeAndReturnKey(params);
	    
	    account.setAccountId(newId.intValue());		
		return account;
	}

}
