package com.oa.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User {
	private Long id;
	private Depertment dept;
	private Set<Role> roles = new HashSet<Role>();
	private String loginName;
	private String password;
	private String name;
	private boolean sex;
	private String phone;
	private String emall;
	private String description;

	/**
	 * 根据权限名判断用户是否有权限
	 * 
	 * @param privilegeName
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		// org.apache.struts2.views.jsp.ui.AnchorTag
		// 超级管理员不需要权限
		if (loginName.equals("admin")) {
			return true;
		}
		// 判断权限
		for (Role r : roles) {
			for (Privilege p : r.getPrivilege()) {
				if (privilegeName.equals(p.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 根据URL判断用户是否有权限
	 * 
	 * @param privUrl
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privUrl) {
		if (loginName.equals("admin")) {
			return true;
		}

		int endIndex = privUrl.indexOf("?");
		// 去掉参数
		if (endIndex > -1) {
			privUrl = privUrl.substring(0, endIndex);
		}
		// 去掉page
		endIndex = privUrl.indexOf("Page");
		if (endIndex > -1) {
			privUrl = privUrl.substring(0, endIndex);
		}
		Collection<String> urls = (Collection<String>) ActionContext
				.getContext().getApplication().get("allPrivilegeUrl");
		//判断权限是否控制访问
		if (!urls.contains(privUrl)) {
			return true;
		} else {
			// 判断权限
			for (Role r : roles) {
				for (Privilege p : r.getPrivilege()) {
					if (privUrl.equals(p.getUrl())) {
						// System.out.println(privUrl+"<==>"+p.getUrl());
						return true;
					}
				}
			}
			return false;
		}
	}

	public Depertment getDept() {
		return dept;
	}

	public void setDept(Depertment dept) {
		this.dept = dept;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmall() {
		return emall;
	}

	public void setEmall(String emall) {
		this.emall = emall;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
