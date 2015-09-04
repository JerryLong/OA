package com.oa.service;

import java.util.List;
import java.util.Set;

import com.oa.entity.Role;

public interface RoleService {

	List<Role> queryAll();

	void delete(Long id);

	void addRole(Role r);

	Role getByid(Long id);

	void update(Role role);

	List<Role> getByids(Long[] roleIds);

}
