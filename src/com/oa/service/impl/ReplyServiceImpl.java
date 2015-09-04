package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oa.dao.ForumDao;
import com.oa.dao.ReplyDao;
import com.oa.entity.Forum;
import com.oa.entity.PageBean;
import com.oa.entity.Reply;
import com.oa.entity.Topic;
import com.oa.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService{

	
	@Resource
	private ReplyDao replyDao;
	@Resource
	private ForumDao forumDao;
	@Override
	public List<Reply> queryByTopic(Topic topic) {
		
		return replyDao.getSession().createQuery("FROM Reply r WHERE r.topic=? ORDER BY r.postTime")
						.setParameter(0, topic)
						.list();
	}
	@Override
	public void save(Reply model) {
		
		replyDao.save(model);
		
		Topic topic = model.getTopic();
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount()+1);
		
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReply(model);
		topic.setLastUpdateTime(model.getPostTime());
		forumDao.update(forum);
//		replyDao.getSession().update(topic);
	}
	@Override
	public PageBean getPageByTopic(int pageNum, int pageSize, Topic topic) {
		List replyList= replyDao.getSession().createQuery("FROM Reply r WHERE r.topic=? ORDER BY r.postTime")
									.setParameter(0, topic)
									.setFirstResult((pageNum-1)*pageSize)
									.setMaxResults(pageSize)
									.list();
		Long recordCount= (Long) replyDao.getSession().createQuery("SELECT COUNT(*) FROM Reply r WHERE r.topic=? ")
								.setParameter(0, topic)
								.uniqueResult();
		
		return  new PageBean(pageNum,pageSize,recordCount.intValue(),replyList);
	}

}
