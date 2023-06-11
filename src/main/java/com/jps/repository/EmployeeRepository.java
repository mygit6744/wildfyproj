package com.jps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Employees;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Integer>  {

}
