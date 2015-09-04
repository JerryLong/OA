package com.oa.text;

import java.lang.reflect.ParameterizedType;

public class SuibianTest <T>{
	public void suTest(T t){
//		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
//		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
		System.out.println(t);
//		System.out.println(clazz.getSimpleName());
	}
	public static void main(String[] args) {
		new SuibianTest<String>().suTest("Strings");
	}
}
