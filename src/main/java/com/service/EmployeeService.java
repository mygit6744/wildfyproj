package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.entity.Employees;
import com.hibernate.dao.EmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<Employees> getDepartment(Integer age) {
		return employeeDAO.getDepartment(age);

	}

	@Transactional
	public void saveOrUpdate(Employees emps) {
		employeeDAO.saveOrUpdate(emps);
	}

	public List<Department> getDepartments() {
		return employeeDAO.getDepartments();
	}

	public List<Employees> fetchemployees() {
		return employeeDAO.fetchemployees();

	}

	public List<Employees> getEmployeesByDept() {
		return employeeDAO.getEmployeesByDept();
	}

}
