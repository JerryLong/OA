package com.oa.base;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	void save(T t);
	void update(T t);
	void delete(Long t);
	T getById(Long id);
	List<T> getByIds(Long[] ids);
	List<T> queryAll();
	Session getSession();
}
