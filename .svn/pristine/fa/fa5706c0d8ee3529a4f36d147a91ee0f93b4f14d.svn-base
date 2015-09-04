package com.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * 岗位/角色
 * @author EXP
 *
 */
public class Role {
	private Long id;
	private String name;
	/**
	 * 岗位说明
	 */
	private String description ;
	private Set<User> users = new HashSet<User>();
	private Set<Privilege> privilege = new HashSet<Privilege>(); 
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Set<Privilege> privilege) {
		this.privilege = privilege;
	}
	
}
