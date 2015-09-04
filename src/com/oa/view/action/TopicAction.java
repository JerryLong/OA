package com.oa.view.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Forum;
import com.oa.entity.PageBean;
import com.oa.entity.Topic;
import com.oa.entity.User;
import com.oa.service.ForumService;
import com.oa.service.ReplyService;
import com.oa.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class TopicAction implements ModelDriven<Topic> {

	@Resource
	private TopicService topicSerevice;
	@Resource
	private ForumService forumService;
	@Resource
	private ReplyService replyService;

	private int pageSize = 10;
	private int pageNum = 1;
	private Long forumId;

	private Topic model = new Topic();

	// 显示主题
	public String show() {
		Topic topic = topicSerevice.getById(model.getId());
		if (topic != null) {

			ActionContext.getContext().getValueStack().push(topic);

			PageBean pageBean = replyService.getPageByTopic(pageNum,pageSize,topic);
			ActionContext.getContext().getValueStack().push(pageBean);;
			return "show";
		}
		return "noTopic";
	}

	// 增加主题
	public String add() {
		model.setAuthor((User) ActionContext.getContext().getSession()
				.get("user"));
		model.setIpAddr(ServletActionContext.getRequest().getLocalAddr());
		model.setPostTime(new Date());
		model.setForum(forumService.getById(forumId));

		topicSerevice.save(model);

		return "toShow";
	}

	public String addPage() {
		Forum f = forumService.getById(forumId);
		ActionContext.getContext().put("forum", f);
		return "savePage";
	}

	public String editPage() {
		Topic topic = topicSerevice.getById(model.getId());
		ActionContext.getContext().put("topic", topic);

		return "savePage";
	}
	public String editType(){
		Topic topic = topicSerevice.getById(model.getId());
		topic.setType(model.getType());
		topicSerevice.update(topic);
		return "toShow";
	}
	public String edit() {

		return "toShow";
	}

	public String delete() {
		topicSerevice.delete(model.getId());
		return "toForumShow";
	}

	@Override
	public Topic getModel() {
		return model;
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
