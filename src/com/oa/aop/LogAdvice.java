package com.oa.aop;

import org.springframework.stereotype.Controller;

@Controller
public class LogAdvice {
	
	public void  before(){
		System.out.println("aop！");
	}
}
