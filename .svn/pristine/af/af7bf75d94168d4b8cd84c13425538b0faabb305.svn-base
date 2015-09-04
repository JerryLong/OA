package com.oa.view.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Privilege;
import com.oa.entity.Role;
import com.oa.service.PrivilegeService;
import com.oa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role>{

	@Resource
	private RoleService roleService;

	@Resource
	private PrivilegeService privilegeService;
	
	private Role model = new Role();
	
	private Long [] privilegeIds;
	
	
	@Override
	public Role getModel() {
		return model;
	}

	//使用模型驱动不使用一下方法
//	private Long id;
//	private String name;
//	private String description;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public void setRoleService(RoleService roleService) {
//		this.roleService = roleService;
//	}
	/**
	 * 显示列表
	 * @return
	 */
	public String list(){
		List<Role> roleList = roleService.queryAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	/**
	 * 删除岗位
	 * @return
	 */
	public String delete(){
		roleService.delete(model.getId());
		
		return "toList"; 
	}
	
	/**
	 * 增加岗位
	 * @return
	 */
	public String add(){
//		Role r  = new Role();
//		r.setName(name);
//		r.setDescription(description);
		roleService.addRole(model);
		return "toList";
	}
	public String editPage(){
		Role role = roleService.getByid(model.getId());
		model.setName(role.getName());
		model.setId(role.getId());
		model.setDescription(role.getDescription());
		return "savePage";
	}
	/**
	 * 增加页面
	 * @return
	 */
	public String addPage(){
		return "savePage";
	}
	/**
	 * 修改用户
	 * @return
	 */
	public String edit(){
//		Role role = new Role();
//		role.setId(id);
//		role.setDescription(description);
//		role.setName(name);
		roleService.update(model);
		return "toList";
	}
	public String setPrivilege(){
		/*
		 */
		Role role = roleService.getByid(model.getId());
		if(privilegeIds!=null)
			for(Long l:privilegeIds){
//			System.out.println(l);
		}
		if(privilegeIds!=null){
			List<Privilege> lists = privilegeService.getByIds(privilegeIds);
			role.setPrivilege(new HashSet<Privilege>(lists));
		}
		
		roleService.update(role); 
		return "toList";
	}
	public String setPrivilegePage(){
		Role role = roleService.getByid(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		List<Privilege> prs =privilegeService.queryTopList();
		ActionContext.getContext().put("prs",prs);
		Set<Privilege> prSet = role.getPrivilege();
		if(prSet!=null){
			privilegeIds = new Long[prSet.size()];
			int temp = 0;
			for(Privilege p:prSet){
				privilegeIds[temp++]=p.getId();
			}
		}
		return "setPrivilegePage";
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
}

