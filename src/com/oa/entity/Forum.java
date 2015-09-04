package com.oa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 模块
 * @author EXP
 *
 */
public class Forum {
	private Long id;
	private String name;
	private String description;
	private Integer position;	//排序规则
	
	private Integer topicCount;		//主题数量
	private Integer articleCount;   //文章数量
	private Set<Topic> topics =  new HashSet<Topic>();
	private Topic lastTopic;    //最后发表的主题
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	public Integer getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(Integer topicCount) {
		this.topicCount = topicCount;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public Topic getLastTopic() {
		return lastTopic;
	}
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
	
}
