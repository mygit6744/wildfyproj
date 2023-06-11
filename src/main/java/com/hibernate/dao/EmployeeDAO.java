package com.hibernate.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entity.Address;
import com.entity.Department;
import com.entity.Employees;
import com.jps.repository.AddressRepository;
import com.jps.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	@Qualifier("employeeRepository")
	EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public List<Employees> getDepartment(Integer age) {
		
		List<Employees> epms = new ArrayList<Employees>();
		employeeRepository.findAll().forEach(p -> epms.add(p));
		return epms;

	}
	
	@Transactional
	public void saveOrUpdate(Employees emps) {
		List<Address> adds = emps.getAddress();
		addressRepository.saveAll(adds);
		employeeRepository.save(emps);
	}
	

	public List<Department> getDepartments() {

		TypedQuery<Collection> query = em.createQuery("SELECT e.department FROM Employees e", Collection.class);
		List<Collection> resultList = query.getResultList();
		List list = new ArrayList(resultList);
		return list;

	}
	
	public List<Employees> fetchemployees() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Employees> query = builder.createQuery(Employees.class);
		Root<Employees> c = query.from(Employees.class);
		TypedQuery<Employees> tq = em.createQuery(query);
		return tq.getResultList();

	}
	
	public List<Employees> getEmployeesByDept() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employees> cr = cb.createQuery(Employees.class);
		Root<Employees> root = cr.from(Employees.class);
		cr.select(root);
		TypedQuery<Employees> q = em.createQuery(cr);
		List<Employees> results = q.getResultList();
		return results;
	}

}
