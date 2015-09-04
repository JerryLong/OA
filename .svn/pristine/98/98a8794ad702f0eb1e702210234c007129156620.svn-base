package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.oa.dao.UserDao;
import com.oa.entity.User;
import com.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Resource(type=UserDao.class)
	private UserDao userDao;
	
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(Long id) {
		
		userDao.delete(id);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public User getById(Long userId) {
		
		return userDao.getById(userId);
	}

	public void initPassword(Long id) {
		String hql = "UPDATE FROM User u SET u.password=?  WHERE u.id=? ";
		userDao.exeQuery(hql,DigestUtils.md5DigestAsHex("1234".getBytes()),id);
		
	}

	@Override
	public User loginVaildation(String loginName, String password) {
		return   userDao.queryNameAndPassword(loginName,DigestUtils.md5DigestAsHex(password.getBytes()));
		
	}

}
