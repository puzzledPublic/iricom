package com.company.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.company.model.DbgAuthority;
import com.company.model.UserVo;
//SpringSecurity에서 Bean 등록
public class LoginService extends JdbcDaoImpl{

	//UserDetailsService 인터페이스 구현
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<UserDetails> users = loadUsersByUsername(username);
		
		if(users.size() == 0){
			throw new UsernameNotFoundException(username+"에 해당하는 아이디가 없음");
		}
		
		UserVo user = (UserVo)users.get(0);
		
		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
		
		if(getEnableAuthorities()){
			dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		if(getEnableGroups()){
			dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		
		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);
		user.setAuthorities(dbAuths);
		
		if(dbAuths.size() == 0){
			throw new UsernameNotFoundException(username+"은 해당 권한이 없음");
		}
		
		return user;
	}
	//JdbcDaoImpl 메소드 오버라이드
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[]{username}, new RowMapper<UserDetails>(){
			@Override
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException{
				String userId = rs.getString(1);
				String password = rs.getString(2);
				String username = rs.getString(3);
				
				return new UserVo(userId, password, username,AuthorityUtils.NO_AUTHORITIES);
			}
		});
	}
	
	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query(getAuthoritiesByUsernameQuery(), new String[]{username}, new RowMapper<GrantedAuthority>(){
			@Override
			public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException{
				String roleName = getRolePrefix() + rs.getInt(2);//DbgAuthority.valueOf(rs.getInt(2)).toString();
				
				return new SimpleGrantedAuthority(roleName);	
			}
		});
	}
	
	@Override
	protected List<GrantedAuthority> loadGroupAuthorities(String username) {
		// TODO Auto-generated method stub
		return super.loadGroupAuthorities(username);
	}
}
