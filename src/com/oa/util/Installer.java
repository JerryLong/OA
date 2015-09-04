package com.oa.util;

import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.oa.entity.Forum;
import com.oa.entity.Privilege;
import com.oa.entity.Reply;
import com.oa.entity.Topic;
import com.oa.entity.User;
import com.oa.service.ForumService;
import com.oa.service.PrivilegeService;
import com.oa.service.ReplyService;
import com.oa.service.TopicService;
import com.oa.service.UserService;

@Controller
@Transactional
public class Installer {

	@Resource
	private ForumService forumService;
	@Resource
	private TopicService topicService;
	@Resource
	private ReplyService replyService;
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UserService userSerevice;
	@Resource
	private PrivilegeService p;

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Installer install = app.getBean(Installer.class);
		// install.install();
		// install.insert();
		install.insertForum();
	}

	public void insertForum() {
		Session session = sessionFactory.openSession();
		Forum forum = forumService.getById(1L);
		User author = userSerevice.getById(2L);
		Reply reply = null;

		for (int i = 0; i < 100; i++) {
			Topic topic = new Topic();
			topic.setAuthor(author);
			topic.setIpAddr("127.0.0.1");
			topic.setForum(forum);
			topic.setPostTime(new Date());
			topic.setStatus(0);

			topic.setContent(GetString.getString());
			topic.setTitle(GetString.getString());
			for (int y = 0; y < 200; y++) {

				reply = new Reply();
				reply.setAuthor(author);
				reply.setContent(GetString.getString());
				reply.setIpAddr("127.0.0.1");
				reply.setPostTime(new Date());
				reply.setStatus(0);
				reply.setTitle(GetString.getString());
				reply.setTopic(topic);
				replyService.save(reply);
			}
			topic.setLastReply(reply);
			
			topic.setLastUpdateTime(reply.getPostTime());
			topic.setReplyCount(1000);
			topicService.save(topic);
			
		}
		
		session.close();
		// session.

	}

	public void insert() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Forum forum = new Forum();
		forum.setName("java模块");
		forum.setDescription("java 学习分享板块");
		forum.setPosition(1);
		session.save(forum);

		forum = new Forum();
		forum.setName("灌水模块");
		forum.setDescription("什么都有！");
		forum.setPosition(2);
		session.save(forum);

		forum = new Forum();
		forum.setName("建议投诉");
		forum.setDescription("有什么好建议分享一下吧！");
		forum.setPosition(3);
		session.save(forum);

		session.getTransaction().commit();
		session.close();
	}

	public void install() {
		Session session = sessionFactory.getCurrentSession();
		// ------------------------------------
		// 初始化超级管理员权限
		User superUser = new User();
		superUser.setName("超级管理员");
		superUser.setLoginName("admin");
		superUser.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
		session.save(superUser);

		// ------------------------------------

		Privilege menu, menu1, menu2, menu3, menu4, menu5;
		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("岗位管理", "/role_list", menu);
		menu2 = new Privilege("部门管理", "/depertment_list", menu);
		menu3 = new Privilege("用户管理", "/user_list", menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(new Privilege("岗位列表", "/role_list", menu1));
		session.save(new Privilege("岗位添加", "/role_add", menu1));
		session.save(new Privilege("岗位删除", "/role_delete", menu1));
		session.save(new Privilege("岗位修改", "/role_edit", menu1));
		// new Privilege("岗位设置权限","/role_list",menu1);

		session.save(new Privilege("部门列表", "/depertment_list", menu2));
		session.save(new Privilege("部门添加", "/depertment_add", menu2));
		session.save(new Privilege("部门删除", "/depertment_delete", menu2));
		session.save(new Privilege("部门修改", "/depertment_edit", menu2));

		session.save(new Privilege("用户列表", "/user_list", menu3));
		session.save(new Privilege("用户添加", "/user_add", menu3));
		session.save(new Privilege("用户删除", "/user_del", menu3));
		session.save(new Privilege("用户修改", "/user_edit", menu3));
		session.save(new Privilege("用户初始化密码", "/user_initPassword", menu3));
		// ------------------------------------
		menu = new Privilege("网上交流", null, null);
		menu1 = new Privilege("论坛管理", "", menu);
		menu2 = new Privilege("论坛", "", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);

		// ------------------------------------
		menu = new Privilege("审批流转", null, null);
		menu1 = new Privilege("起草申请", "", menu);
		menu2 = new Privilege("我的申请查询", "", menu);
		menu3 = new Privilege("待我审批", "", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		// ------------------------------------
		menu = new Privilege("实用工具", null, null, "");
		menu1 = new Privilege("公司网站", "", menu);
		menu2 = new Privilege("火车时刻", "http://qq.ip138.com/train/", menu);
		menu3 = new Privilege("飞机航班", "http://www.airchina.com.cn/", menu);
		menu4 = new Privilege("邮编/区号", "http://www.ip138.com/post/", menu);
		menu5 = new Privilege("国际时间", "http://www.timedate.cn/", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);

		// ------------------------------------
		// ------------------------------------

	}
}
