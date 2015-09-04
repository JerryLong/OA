package com.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Forum;
import com.oa.service.ForumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ForumManageAction implements ModelDriven<Forum>{
	
	@Resource
	private ForumService forumService; 
	
	private Forum model = new Forum();
	
	public String list(){
		List<Forum> forumList = forumService.queryAll();
		ActionContext.getContext().put("forumList",forumList);
		
		return "list";
	}
	public String delete(){
		
		forumService.delete(model.getId());
		
		return "toList";
	}
	public String edit(){
		Forum f = forumService.getById(model.getId());
		f.setName(model.getName());
		f.setDescription(model.getDescription());
		
		forumService.update(f);
		return "toList";
	}
	public String editPage(){
		System.out.println(model.getId());
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);
		
		return "savePage";
	}
	public String  add(){
		Forum f = new  Forum();
		
		f.setName(model.getName());
		f.setDescription(model.getDescription());
		f.setPosition(null);
		
		forumService.add(f);
		return "toList";
	}
	public String addPage(){
		
		return "savePage";
	}
	@Override
	public Forum getModel() {
		return model;
	}
	public String down(){
		
		forumService.moveDown(model.getId());
		
		return "toList";
	}
	public String up(){
		forumService.moveUp(model.getId());
		
		return "toList";
	}
}
