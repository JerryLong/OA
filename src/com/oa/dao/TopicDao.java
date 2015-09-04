package com.oa.dao;

import com.oa.base.BaseDao;
import com.oa.entity.Topic;

public interface TopicDao extends BaseDao<Topic>{

	void hiddenReply(Topic topic);

}
