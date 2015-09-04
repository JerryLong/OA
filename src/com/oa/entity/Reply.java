package com.oa.entity;

/**
 * 回复实体
 * @author EXP
 *
 */
public class Reply  extends Article{
	
	private Topic topic ;//属于某个主题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
