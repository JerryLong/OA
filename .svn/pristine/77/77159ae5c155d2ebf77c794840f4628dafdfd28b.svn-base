package com.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{

	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;

	public Session getSession(){
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
		
	}
	
	
	public BaseDaoImpl() {
		//获取当前对象的父类的泛型的类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取第一个java.lang.reflect.Type
		clazz =	(Class<T>) pt.getActualTypeArguments()[0];
//		System.out.println(clazz);
	}



	@Override
	public void save(T t) {
		getSession().save(t);
		
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(Long id) {
		Object obj = getById(id);
		getSession().delete(obj);
	}

	@Override
	public T getById(Long id) {
//		JavassistLazyInitializer
		Session session = getSession();
		Object obj = session.get(clazz, id);
//		System.out.println(obj.getClass());
		return (T) obj;
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		return 	getSession().createQuery("FROM "+clazz.getSimpleName()+" WHERE id IN (:ids)")//
		.setParameterList("ids", ids).list();
	}

	@Override
	public List<T> queryAll() {
		List<T> list = getSession().createQuery("FROM "+clazz.getSimpleName()).list();
		System.out.println(clazz.getSimpleName());
		return 	list;
	}



}
