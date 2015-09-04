package com.oa.util;

import com.oa.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		//获取名称空间
		String namespace = invocation.getProxy().getNamespace();
		//获取actionname
		String actionname = invocation.getProxy().getActionName();		
		String privUrl = namespace+actionname;
//		System.out.println(namespace+actionname);
//		System.out.println(""+(user==null?"没有用户":user.getName()));
		
		if(user==null){
			if("/user_login".equals(privUrl)){
				return invocation.invoke();
			}
			return "loginPage";
		}else if(user.hasPrivilegeByUrl(privUrl)){
			return invocation.invoke();
			
		}else{
			return "noPrivilegeError";
		}
	}

}
