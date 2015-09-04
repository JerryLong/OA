package com.oa.view.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.oa.entity.Depertment;
import com.oa.entity.Role;
import com.oa.entity.User;
import com.oa.service.DepertmentService;
import com.oa.service.RoleService;
import com.oa.service.UserService;
import com.oa.util.DepertmentUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	@Resource
	private UserService userService ;
	@Resource
	private DepertmentService deptService;
	@Resource
	private RoleService roleService;
	
	private Long deptId ;
	private Long[] roleIds;
	
	private User model = new User();
	
	public String list(){
		List<User> users = userService.queryAll();
		ActionContext.getContext().put("users", users);
		return "list";
	}
	public String edit(){
		User user = userService.getById(model.getId());

		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setPhone(model.getPhone());
		user.setSex(model.getSex());
		user.setDescription(model.getDescription());
		user.setEmall(model.getEmall());

		user.setDept(deptService.getById(deptId));
		user.setRoles(new HashSet<Role>(roleService.getByids(roleIds)));
		
		userService.update(user);
		return "toList";
	}
	public String del(){
/*		Long id = model.getId();
		System.out.println("删除："+id);
		userService.delete(id);*/
		
		userService.delete(model.getId());
		return "toList";
	}
	public String add(){
		User user = new User();
		user.setDescription(model.getDescription());
		user.setEmall(model.getEmall());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setPassword(DigestUtils.md5DigestAsHex("1234".getBytes()));
		user.setPhone(model.getPhone());
		user.setSex(model.getSex());
		user.setDept(deptService.getById(deptId));
		
		user.setRoles(new HashSet<Role>(roleService.getByids(roleIds)));
		
		userService.save(user);
		
		return "toList";
	}
	public String addPage(){
		List<Depertment> depts = DepertmentUtils.getAllDepertment(deptService.queryTop());
		List<Role> roles = roleService.queryAll();
		ActionContext.getContext().put("depts",depts);
		ActionContext.getContext().put("roles",roles);
		
		model.setId(null);
		return "savePage";
	}
	public String editPage(){
		List<Depertment> depts = DepertmentUtils.getAllDepertment(deptService.queryTop());
		List<Role> roles = roleService.queryAll();
		List<Depertment> ls=new ArrayList<Depertment>(depts);
		ActionContext.getContext().put("depts",ls);
		
		ActionContext.getContext().put("roles",roles);
		
		User user = userService.getById(model.getId());

		ActionContext.getContext().getValueStack().push(user);
		
		
		//回显部门和岗位
		if(user.getDept()!=null){
			deptId= user.getDept().getDeptId();
		}
		Set<Role> rs = user.getRoles();
		if(rs!=null){
			roleIds = new Long[rs.size()];
			int temp=0;
			for(Role r :rs){
				roleIds[temp++]=r.getId();
			}
		}
//		System.out.println(model.getName());
		return "savePage";
	}
	public String initPassword(){
		userService.initPassword(model.getId());
		return "toList";
	}
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		User user = userService.loginVaildation(model.getLoginName(),model.getPassword());
		if(user!=null){
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}else{
			addFieldError("loginError", "用户名或密码错误！");
			return "loginPage";
		}
	}
	/**
	 * 登录页面
	 * @return
	 */
	public String loginPage(){
		
		
		return "loginPage";
	}
	/**
	 * 退出登录
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	@Override
	public User getModel(){
		return model;
	}
}
