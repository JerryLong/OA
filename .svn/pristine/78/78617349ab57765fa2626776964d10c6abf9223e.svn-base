package com.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;

import com.oa.base.BaseDaoImpl;
import com.oa.dao.DepertmentDao;
import com.oa.entity.Depertment;

@Controller
public class DepertmentDaoImpl extends BaseDaoImpl<Depertment> implements DepertmentDao  {

	@Override
	public List<Depertment> queryHql(String hql,Object... args) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		
		for(int i=0;i<args.length;i++){
			query.setParameter(i, args[i]);
		}
		return 	query.list();
	}

}
