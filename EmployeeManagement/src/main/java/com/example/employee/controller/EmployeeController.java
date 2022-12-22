package com.example.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepo;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/addEmployee")
	@ResponseBody
	public Optional<Employee> addEmployees(@RequestParam int id,String name,String email,String dept)
	{
		Employee emp = new Employee();
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmpEmail(email);
		emp.setEmpDept(dept);
		repo.save(emp);
		
		return repo.findById(id);
	}
	
	@RequestMapping("/deleteEmployee")
	@ResponseBody
	public Optional<Employee> deleteEmp(@RequestParam int id)
	{
		repo.deleteById(id);
		return repo.findById(id);
	}
	
	@RequestMapping("/getAllEmployee")
	@ResponseBody
	public List<Employee> displayEmployee()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/getEmployee")
	@ResponseBody
	public Optional<Employee> displayEmployeeById(@RequestParam int id)
	{
		return repo.findById(id);
	}
}
