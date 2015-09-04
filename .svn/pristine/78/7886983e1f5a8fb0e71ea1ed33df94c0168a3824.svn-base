package com.oa.text;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class UserDaoa {

	@Resource()
	SessionFactory sessionFactory;
	
	@Transactional
	public void saveUser(){
		Session session = sessionFactory.getCurrentSession();
		
		session.save(new User("xiaom","em23"));
		int i= 1/0;
		session.save(new User("ll2l2","em23"));
		
//		session.close();
	}
}
