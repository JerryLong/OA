package com.oa.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.oa.base.BaseDaoImpl;
import com.oa.dao.PrivilegeDao;
import com.oa.entity.Privilege;

@Controller
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@Override
	public List<Privilege> queryTopList() {
		return 	getSession().createQuery("FROM Privilege p WHERE p.parent IS NULL").list();
	}

	@Override
	public Collection<String> allPrivilegeUrl() {
		return getSession().createQuery("SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL").list();
	}



}
