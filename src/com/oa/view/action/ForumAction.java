package com.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Forum;
import com.oa.entity.PageBean;
import com.oa.entity.Topic;
import com.oa.service.ForumService;
import com.oa.service.TopicService;
import com.oa.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ForumAction implements ModelDriven<Forum>{

	@Resource
	private ForumService forumService;
	@Resource
	private TopicService topicService;
	
	/**
	 * 0	//全部主题		
	 * 1	//全部精华帖		
	 */
	private int viewType = 	0;
	/**
	 * 0	//默认排序			
	 * 1	//按最后更新时间排序	
	 * 2	//按主题发表时间排序	
	 * 3	//按回复数量排序		
	 */
	private int orderBy = 	0;
	/**
	 * flase	//降序
	 * true		//升序
	 */
	private boolean reverse  = false;
	
	private int pageSize = 10;
	private int pageNum = 1;
	private Forum model = new Forum();
		
	public String list(){
		List<Forum> forumList = forumService.queryAll();
		ActionContext.getContext().put("forumList",forumList);
		
		return "list";
	}
	public String show(){
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum",forum);
		
//		"FROM Topic t WHERE t.forum= ? AND t.status=0 ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC , t.lastUpdateTime DESC"
//		List<Object> patameters = new ArrayList<Object>();
//		String hql = "FROM Topic t WHERE t.status=0 AND t.forum=? ";
//		patameters.add(forum);
//		if(viewType==1){
//			hql += "AND t.type=? ";
//			patameters.add(Topic.TYPE_BEST);
//		}
//		System.out.println(orderBy);
//		if(orderBy==1){
//			hql+="ORDER BY t.lastUpdateTime "+(reverse?"DESC":"ASC");
//		}else if(orderBy==2){
//			hql+="ORDER BY t.postTime "+(reverse?"DESC":"ASC");
//			
//		}else if(orderBy==3){
//			hql+="ORDER BY  t.lastUpdateTime "+(reverse?"DESC":"ASC");
//			
//		}else{
//			hql+="ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC , t.lastUpdateTime DESC";
//			
//		}
//		System.out.println(hql);
		
		QueryHelper qh = new QueryHelper(Topic.class ,"t");
		if(viewType==1){
			qh.setWhere("t.type=?",Topic.TYPE_BEST);
		}
		if(orderBy==1){
			qh.setOrderBy("t.lastUpdateTime",reverse);
		}else if(orderBy==2){
			qh.setOrderBy("t.postTime",reverse);
			
		}else if(orderBy==3){
			qh.setOrderBy("t.replyCount",reverse);
		}else {
			qh.setOrderBy("(CASE t.type WHEN 2 THEN 2 ELSE 0 END)",false);
			qh.setOrderBy("t.lastUpdateTime",false);
		}
		
		PageBean pageBean = topicService.queryPageBean(pageNum,pageSize,qh);
		
		
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}
	
	@Override
	public Forum getModel() {
		return model;
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
	public int getViewType() {
		return viewType;
	}
	public void setViewType(int viewType) {
		this.viewType = viewType;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int oderBy) {
		this.orderBy = oderBy;
	}
	public boolean isReverse() {
		return reverse;
	}
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}
	
}
