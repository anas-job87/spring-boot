package com.anas.springboot267.cacheabstraction.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReposiotry extends JpaRepository<Employee, Long>{

}
