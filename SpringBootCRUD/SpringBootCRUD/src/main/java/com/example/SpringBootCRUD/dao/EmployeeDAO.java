package com.example.SpringBootCRUD.dao;

import com.example.SpringBootCRUD.model.Department;
import com.example.SpringBootCRUD.model.Employee;

import java.util.List;

public interface EmployeeDAO {

	public boolean addNewEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(Long id);

	public List<Department> getDepartments();

}
