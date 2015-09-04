package com.oa.dao;

import com.oa.base.BaseDao;
import com.oa.entity.User;

public interface UserDao extends BaseDao<User> {

	void exeQuery(String hql, Object ... args );


	User queryNameAndPassword(String loginName, String password);



}
