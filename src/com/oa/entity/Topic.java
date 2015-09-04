package com.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 主题实体
 * @author EXP
 *
 */
public class Topic extends Article{
	//置顶贴
	public static final int TYPE_TOP 	= 2;
	//精华贴
	public static final int TYPE_BEST 	= 1;
	//普通贴
	public static final int TYPE_NORMAL = 0;
	
	
	private int type;	          //主题类型
	private int replyCount;       //回复数量
	private Date lastUpdateTime;  //最后跟新时间
	private Forum forum;		//属于那个板块
	private Reply lastReply;      //最后回复
	private Set<Reply> replys = new HashSet<Reply>();
	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
}
