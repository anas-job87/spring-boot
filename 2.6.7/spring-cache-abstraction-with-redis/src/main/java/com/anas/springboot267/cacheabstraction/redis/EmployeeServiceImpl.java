package com.anas.springboot267.cacheabstraction.redis;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "Employee")
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeReposiotry repository;
	
	public EmployeeServiceImpl(EmployeeReposiotry repository) {
		this.repository = repository;
	}

	@Override
	public Employee create(Employee employee) {
		return repository.save(employee);
	}

	@Override
	@Cacheable(key="#id")
	public Employee read(Long id) {
		Employee employee = repository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found with the given identifier"));
		return employee;
	}

	@Override
	@CachePut( key="#id")
	public Employee update(Long id, Employee employee) {
		Employee employeeDb = read(id);
		employeeDb.setName(employee.getName());
		return repository.save(employeeDb);
	}

	@Override
	@CacheEvict(key="#id")
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	@Cacheable
	public List<Employee> getAll() {
		return repository.findAll();
	}
	
}
