package com.techm.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.Exception.ResourceNotFoundException;
import com.techm.Repo.EmpRepository;
import com.techm.entity.Employee;

@RestController
@RequestMapping("/Api/Employee")
public class EmployeeController {

	@Autowired
	EmpRepository empRepository;
	
	@GetMapping("fetch")
	public List<Employee>EmpData(){
		return empRepository.findAll();
	}
	@PostMapping("Add")
	public Employee AddData(@RequestBody Employee employee) {
		return empRepository.save(employee);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<Employee> getbyid(@PathVariable long id) {
		Employee employee =empRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id"+id));
		return ResponseEntity.ok(employee);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<Employee>updateEmp(@PathVariable long id,@RequestBody Employee employee){
		Employee emp=empRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id"+id));
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setPassword(employee.getPassword());
		emp.setConfirmpsw(employee.getConfirmpsw());
		Employee getEmp=empRepository.save(emp);
		return ResponseEntity.ok(getEmp);		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Map<String, Boolean>>Empdetails(@PathVariable long id){
		Employee employee=empRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id"+id));
		empRepository.delete(employee);
		Map<String, Boolean>Empdelete=new HashMap<String, Boolean>();
		Empdelete.put("Delete", Boolean.TRUE);
		
		return ResponseEntity.ok(Empdelete);
		
	}
}
