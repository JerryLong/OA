package com.oa.entity;

import java.util.HashSet;
import java.util.Set;

public class Privilege {
	private Long id;
	private String name;
	private String ico;
	private String url;
	private Privilege parent;//上级权限
	
	private Set<Privilege> chlidren = new HashSet<Privilege>();//下级 权限
	private Set<Role> roles = new HashSet<Role>();//角色
	
	
	public Privilege() {}
	
	public Privilege(String name, String url, Privilege parent, String ico) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
		this.ico = ico;
	}

	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Privilege> getChlidren() {
		return chlidren;
	}
	public void setChlidren(Set<Privilege> chlidren) {
		this.chlidren = chlidren;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	
}
