package com.oa.service;

import java.util.List;

import com.oa.entity.Depertment;

public interface DepertmentService {
	public void update(Depertment dept);

	public void delete(Long id);

	public List<Depertment> queryAll();

	public void save(Depertment model);

	public Depertment getById(Long deptId);

	public List<Depertment> queryChildren(Long deptId);

	public List<Depertment> queryTop();

}
