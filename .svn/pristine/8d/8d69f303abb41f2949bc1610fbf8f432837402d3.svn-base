package com.oa.dao.impl;

import org.springframework.stereotype.Controller;

import com.oa.base.BaseDaoImpl;
import com.oa.dao.TopicDao;
import com.oa.entity.Topic;

@Controller
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

	@Override
	public void hiddenReply(Topic topic) {
		getSession().createQuery("UPDATE Reply r SET r.status=1 WHERE r.topic=?")
					.setParameter(0, topic)
					.executeUpdate();
		
	}
	
}
