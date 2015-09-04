package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oa.dao.ForumDao;
import com.oa.entity.Forum;
import com.oa.service.ForumService;
@Service
@Transactional
public class ForumServiceImpl implements ForumService{
	
	@Resource
	private ForumDao forumDao;


	@Override
	public List<Forum> queryAll() {
		return forumDao.queryAll();
	}


	@Override
	public void delete(Long id) {
		forumDao.delete(id);
	}


	@Override
	public void update(Forum model) {
		forumDao.update(model);
	}


	@Override
	public Forum getById(Long id) {
		return 	forumDao.getById(id);
	}


	@Override
	public void add(Forum f) {
		int last = forumDao.getMaxPosition();
		f.setPosition(last+1);
		forumDao.save(f);
	}


	@Override
	public void moveDown(Long id) {
		Forum forum = getById(id);
		Forum other  = (Forum)forumDao.getSession()
					.createQuery("FROM Forum f WHERE f.position>? ORDER BY f.position ")
					.setParameter(0, forum.getPosition())
					.setFirstResult(0)
					.setMaxResults(1)
					.uniqueResult();
		if(other==null)
			return ;
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		update(forum);
		update(other);
	}


	@Override
	public void moveUp(Long id) {
		
		Forum forum = getById(id);
		
		Forum other  = (Forum) forumDao.getSession()
				.createQuery("FROM Forum f WHERE f.position<? ORDER BY f.position DESC")
				.setParameter(0, forum.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		if(other==null)
			return ;
		
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		update(forum);
		update(other);

	}
	
}
