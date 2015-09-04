package com.oa.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oa.dao.PrivilegeDao;
import com.oa.entity.Privilege;
import com.oa.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService{

	@Resource
	private PrivilegeDao privilegeDao;
	
	@Override
	public List<Privilege> getByIds(Long[] privileges) {
		return privilegeDao.getByIds(privileges);
				
	} 

	@Override
	public List<Privilege> queryAll() {
		
		return privilegeDao.queryAll();
	}

	public List<Privilege> queryTopList() {
		return 	privilegeDao.queryTopList();
	}

	@Override
	public Collection<String> allPrivilegeUrl() {
		return privilegeDao.allPrivilegeUrl();
	}


}
