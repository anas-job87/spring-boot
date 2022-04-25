package com.anas.springboot267.cacheabstraction.redis;

import java.util.List;

public interface EmployeeService {
	
	public Employee create(Employee employee);
	
	public Employee read(Long id);
	
	public Employee update(Long id, Employee employee);
	
	public void delete(Long id);
	
	public List<Employee> getAll();
}
