package com.oa.dao.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.oa.base.BaseDaoImpl;
import com.oa.dao.UserDao;
import com.oa.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{


	
	@Override
	public void exeQuery(String hql,Object ... args) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for(int i=0;i<args.length;i++){
			query.setParameter(i,args[i]);
		}
		query.executeUpdate();
	}

	@Override
	public User queryNameAndPassword(String loginName, String password) {
		return  (User) getSession().createQuery("FROM User u WHERE u.loginName=? AND u.password=?")
						.setParameter(0, loginName)
						.setParameter(1, password)
						.uniqueResult();
		
	}



}
