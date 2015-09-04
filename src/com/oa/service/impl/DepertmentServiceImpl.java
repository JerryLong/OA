package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oa.dao.DepertmentDao;
import com.oa.entity.Depertment;
import com.oa.service.DepertmentService;

@Service
@Transactional
public class DepertmentServiceImpl implements DepertmentService {

	@Resource
	private DepertmentDao deptDao;

	public void setDeptDao(DepertmentDao deptDao) {
		this.deptDao = deptDao;
	}

	public void update(Depertment dept) {
		deptDao.update(dept);

	}

	public void delete(Long id) {
//		System.out.println(id);
		deptDao.delete(id);
	}

	public List<Depertment> queryAll() {
		return deptDao.queryAll();
	}

	public void save(Depertment model) {
		deptDao.save(model);
	}

	@Override
	public Depertment getById(Long deptId) {
		if (deptId == null) {
			return null;
		} else {

			return deptDao.getById(deptId);
		}
	}

	@Override
	public List<Depertment> queryChildren(Long deptId) {
		String hql = "FROM Depertment d WHERE d.deptUp.deptId=?";
		return deptDao.queryHql(hql,deptId);
	}

	@Override
	public List<Depertment> queryTop() {
		String hql = "FROM Depertment d WHERE d.deptUp IS NULL";
		
		return deptDao.queryHql(hql);
	}
}
