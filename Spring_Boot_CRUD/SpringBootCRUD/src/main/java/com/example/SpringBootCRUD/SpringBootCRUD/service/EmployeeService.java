package com.example.SpringBootCRUD.SpringBootCRUD.service;

import com.example.SpringBootCRUD.SpringBootCRUD.model.Department;
import com.example.SpringBootCRUD.SpringBootCRUD.model.Employee;

import java.util.List;

public interface EmployeeService {

	public boolean addNewEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(Long id);

	public List<Department> getDepartments();


}
