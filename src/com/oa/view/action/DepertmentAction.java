package com.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Depertment;
import com.oa.service.DepertmentService;
import com.oa.util.DepertmentUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DepertmentAction extends ActionSupport implements ModelDriven<Depertment>{
	
	private Depertment model = new Depertment();
	
	@Resource
	private DepertmentService deptService;
	
	private Long deptUpId;
	
	public String edit(){
		model.setDeptUp(deptService.getById(deptUpId));
		deptService.update(model);
		
		return "toList";
	}
	public String delete(){
		deptService.delete(model.getDeptId());
//		System.out.println("delete show chlidren-->"+deptUpId);
		return "toList";
	}
	public String list(){
		
		List<Depertment> depts ;
//		System.out.println("show chlidren-->"+deptUpId);
		
		if(model.getDeptId()==null){
			depts = deptService.queryTop();
		}
		else{
			depts = deptService.queryChildren(model.getDeptId());
//			javax.persistence.validateion.mode
			Depertment deptup =null;
//			if(model.getDeptUp()!=null)
				deptup= deptService.getById(model.getDeptId()).getDeptUp();
			
			Long updept = deptup==null?null:deptup.getDeptId();
			ActionContext.getContext().put("updept",updept);
		}
		ActionContext.getContext().put("depts",depts);
		return "list";
	}
	public String add(){
		
		Depertment deptup = deptService.getById(deptUpId);
		model.setDeptUp(deptup);
		deptService.save(model);
//		System.out.println("add show chlidren-->"+deptUpId);
		return "toList";
	}
	
	
	public String addPage(){
		
		//为前台准备部门列表数据
		List<Depertment> lists = DepertmentUtils.getAllDepertment(deptService.queryTop()); 
		
		ActionContext.getContext().put("depts",lists);
		
		return "savePage";
	}
	public String editPage(){
		List<Depertment> lists = DepertmentUtils.getAllDepertment(deptService.queryTop()); 
		ActionContext.getContext().put("depts",lists);
		
		Depertment dept = deptService.getById(model.getDeptId());
		model.setDeptName(dept.getDeptName());
		model.setDescription(dept.getDescription());
		model.setDeptUp(dept.getDeptUp());
		model.setDeptId(dept.getDeptId());
		setDeptUpId(dept.getDeptUp()==null?null:dept.getDeptUp().getDeptId());
		return "savePage";
	}
	
	
	
	@Override
	public Depertment getModel() {
		return model;
	}
	public Long getDeptUpId() {
		return deptUpId;
	}
	public void setDeptUpId(Long deptUpId) {
		this.deptUpId = deptUpId;
	}
}
