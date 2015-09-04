package com.oa.view.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Reply;
import com.oa.entity.Topic;
import com.oa.entity.User;
import com.oa.service.ReplyService;
import com.oa.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ReplyAction implements ModelDriven<Reply>{

	@Resource
	private ReplyService replyService;
	@Resource
	private TopicService topicService;
	
	private Reply model = new Reply(); 
	
	private Long topicId;
	
	public String addPage(){
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic",topic);
		return "addPage";
	}
	public String add(){
		model.setAuthor((User)ActionContext.getContext().getSession().get("user"));
		model.setIpAddr(ServletActionContext.getRequest().getLocalAddr());
		model.setTopic(topicService.getById(topicId));
		model.setPostTime(new Date());
		
		replyService.save(model);

		return "toTopicShow";
	}
	
	@Override
	public Reply getModel() {
		return model;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	

}
