package com.oa.service;

import java.util.List;

import com.oa.entity.Forum;
import com.oa.entity.PageBean;
import com.oa.entity.Topic;
import com.oa.util.QueryHelper;

public interface TopicService {

	List<Topic> queryAll();

	void save(Topic model);

	Topic getById(Long id);

	@Deprecated
	List<Topic> queryByForum(Forum forum);

	void delete(Long id);

	void update(Topic topic);
	@Deprecated
	PageBean queryPageBean(int pageNum,int pageSize,Forum forum);

	PageBean queryPageBean(int pageNum, int pageSize, String hql,
			List<Object> patameters);

	PageBean queryPageBean(int pageNum, int pageSize, QueryHelper qh);

}
