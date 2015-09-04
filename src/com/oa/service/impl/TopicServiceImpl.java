package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.oa.dao.ForumDao;
import com.oa.dao.TopicDao;
import com.oa.entity.Forum;
import com.oa.entity.PageBean;
import com.oa.entity.Topic;
import com.oa.service.TopicService;
import com.oa.util.QueryHelper;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

	@Resource
	private TopicDao topicDao;

	@Resource
	private ForumDao forumDao;

	@Override
	public List<Topic> queryAll() {
		List<Topic> list = topicDao.queryAll();
		return list;
	}

	@Override
	public void save(Topic model) {

		model.setLastUpdateTime(model.getPostTime());
		model.setLastReply(null);
		model.setReplyCount(0);
		model.setType(Topic.TYPE_NORMAL);

		Forum forum = model.getForum();
		forum.setLastTopic(model);
		forum.setTopicCount(forum.getTopicCount() + 1);
		forum.setArticleCount(forum.getArticleCount() + 1);

		forumDao.update(forum);
		topicDao.save(model);

	}

	@Override
	public Topic getById(Long id) {
		Topic topic = topicDao.getById(id);
		return topic.getStatus() == 0 ? topic : null;
	}

	@Deprecated
	@Override
	public List<Topic> queryByForum(Forum forum) {
		Session session = topicDao.getSession();
		return session
				.createQuery(
						"FROM Topic t WHERE t.forum= ? AND t.status=0 ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC , t.lastUpdateTime DESC")
				.setParameter(0, forum).list();

	}

	@Override
	public void delete(Long id) {
		Topic topic = topicDao.getById(id);
		topic.setStatus(1);
		topicDao.update(topic);
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount() - 1);
		forum.setArticleCount(forum.getArticleCount() - 1);
		forum.getLastTopic();
		topicDao.hiddenReply(topic);
		forumDao.update(forum);

	}

	@Override
	public PageBean queryPageBean(int pageNum, int pageSize, Forum forum) {
		Session session = topicDao.getSession();
		List list = session
				.createQuery(
						"FROM Topic t WHERE t.forum= ? AND t.status=0 ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC , t.lastUpdateTime DESC")
				.setParameter(0, forum)
				.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
		Long count = (Long) session
				.createQuery(
						"SELECT COUNT(*) FROM Topic t WHERE t.forum= ? AND t.status=0 ")
				.setParameter(0, forum).uniqueResult();
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

	@Override
	public void update(Topic topic) {
		topicDao.update(topic);
	}

	@Override
	public PageBean queryPageBean(int pageNum, int pageSize, String hql,
			List<Object> patameters) {
		Session session = topicDao.getSession();
		Query query = session.createQuery(hql);
		
		for(int i=0;i<patameters.size();i++){
			query.setParameter(i, patameters.get(i));
		}
		
		List list = query.setFirstResult((pageNum - 1) * pageSize)
						.setMaxResults(pageSize).list();
				Query countQuery =  session.createQuery("SELECT COUNT(*) "+hql);
				for(int i=0;i<patameters.size();i++){
					countQuery.setParameter(i, patameters.get(i));
				}
		Long count = (Long) countQuery.uniqueResult();
		return new PageBean(pageNum, pageSize, count.intValue(), list);

	}

	@Override
	public PageBean queryPageBean(int pageNum, int pageSize, QueryHelper qh) {
		Session session = topicDao.getSession();
		Query query = session.createQuery(qh.getHql());
		List patameters = qh.getPrment();
		for(int i=0;i<patameters.size();i++){
			query.setParameter(i, patameters.get(i));
		}
		
		List list = query.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list();
		Query countQuery =  session.createQuery(qh.getCountHql());
		for(int i=0;i<patameters.size();i++){
			countQuery.setParameter(i, patameters.get(i));
		}
		Long count = (Long) countQuery.uniqueResult();
		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

}
