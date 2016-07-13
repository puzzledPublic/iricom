package com.company.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.Assert;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVo implements UserDetails{

	private static final long serialVersionUID = -8286295543684773981L;
	
	private int number;//숫자
	private String userId;//아이디
	private String userName;//이름
	private String email;//이메일
	private String password;//패스워드
	private String address;//주소
	private int postcode;//우편주소
	private Date createdDate;//아이디 생성일
	private Date lastDate;//접속일
	private DbgAuthority authority;//권한
	
	private Set<GrantedAuthority> authorities; //계정이 가진 권한 목록
	
	public UserVo() {}
	public UserVo(String userId, String userName, String email){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
	}
	public UserVo(String userId, String password, String userName, Collection<? extends GrantedAuthority> authorities){
		this.userId = userId;
		this.password = password;
		this.userName =userName;
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}
	public UserVo(String userId, String userName, String email, String address, int postcode){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.postcode = postcode;
	}
	public UserVo(String userId, String userName ,String email, String password, Date lastDate){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.lastDate = lastDate;
	}
	public UserVo(String userId, String userName ,String email, String password, String address, int postcode){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.postcode = postcode;
	}
	public UserVo(String userId, String userName ,String email, String password, String address, int postcode, Collection<? extends GrantedAuthority> authorities){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.postcode = postcode;
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public DbgAuthority getAuthority() {
		return authority;
	}
	public void setAuthority(DbgAuthority authority) {
		this.authority = authority;
	}
	
	//UserDetails 구현
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities){
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getUserId();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities){
		//Assert.assertNotNull("Connot pass a null GrantedAuthorities Collection",authorities);
		
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());
		
		for(GrantedAuthority grantedAuthority : authorities){
			//Assert.assertNotNull("GrantedAuthority list cannot contain any null elements",grantedAuthority);
			sortedAuthorities.add(grantedAuthority);
		}
		return sortedAuthorities;
	}
	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable{
		private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
		
		@Override
		public int compare(GrantedAuthority o1, GrantedAuthority o2) {
		// TODO Auto-generated method stub
			if(o2.getAuthority() == null){
				return -1;
			}
			if(o1.getAuthority() == null){
				return -1;
			}
			return o1.getAuthority().compareTo(o2.getAuthority());
		}
	}
}
