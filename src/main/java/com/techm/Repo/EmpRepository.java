package com.techm.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{

}
