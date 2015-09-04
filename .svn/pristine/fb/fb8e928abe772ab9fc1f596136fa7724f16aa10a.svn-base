package com.oa.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.RoleDao;
import com.oa.entity.Role;
import com.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Resource
	RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override 
	public List<Role> queryAll() {
		return roleDao.queryAll();
	}
	
	@Override
	public void delete(Long id) {
		
		roleDao.delete(id);
	}

	@Override
	public void addRole(Role r) {
		roleDao.save(r);
	}

	@Override
	public Role getByid(Long id) {
		return roleDao.getById(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
		
	}

	@Override
	public List<Role> getByids(Long[] roleIds) {
		return roleDao.getByIds(roleIds);
	}
	

}
