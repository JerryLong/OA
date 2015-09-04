package com.oa.service;

import java.util.List;

import com.oa.entity.PageBean;
import com.oa.entity.Reply;
import com.oa.entity.Topic;

public interface ReplyService {

	List<Reply> queryByTopic(Topic topic);

	void save(Reply model);

	PageBean getPageByTopic(int pageNum, int pageSize, Topic topic);

}
