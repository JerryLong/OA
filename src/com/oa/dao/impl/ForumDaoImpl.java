package com.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.oa.base.BaseDaoImpl;
import com.oa.dao.ForumDao;
import com.oa.entity.Forum;

@Controller
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao{
	@Override
	public List<Forum> queryAll() {
		return 	getSession().createQuery("FROM Forum f  ORDER BY f.position").list();
	}

	@Override
	public int getMaxPosition() {
		
		return (int) getSession().createQuery("SELECT MAX(f.position) FROM Forum f").uniqueResult();
	}
}
