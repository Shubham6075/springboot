package com.example.SpringBootCRUD.dao.impl;

import com.example.SpringBootCRUD.dao.EmployeeDAO;
import com.example.SpringBootCRUD.model.Department;
import com.example.SpringBootCRUD.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public boolean addNewEmployee(Employee emp) {
		String sql = "insert into employee(first_name, last_name, email, dob, gender, dep_id) values(?,?,?,?,?,?)";
		int count = getJdbcTemplate().update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, emp.getFirstName());
				ps.setString(2, emp.getLastName());
				ps.setString(3, emp.getEmail());
				ps.setString(4, emp.getDob());
				ps.setString(5, emp.getGender());
				ps.setLong(6, emp.getDep().getId());

				return ps;
			}
		});

		if (count == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return Objects.requireNonNull(getJdbcTemplate()).query("select * from employee", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> empList = new ArrayList<>();

				while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getLong(1));
					emp.setFirstName(rs.getString(2));
					emp.setLastName(rs.getString(3));
					emp.setEmail(rs.getString(4));
					emp.setDob(rs.getString(5));
					emp.setGender(rs.getString(6));

					Department dep = new Department();
					dep.setId(rs.getLong(7));

					emp.setDep(dep);

					empList.add(emp);
				}

				return empList;
			}

		});
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return getJdbcTemplate().query("select * from employee where id=" + id, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee emp = new Employee();

				while(rs.next()) {
					emp.setId(rs.getLong(1));
					emp.setFirstName(rs.getString(2));
					emp.setLastName(rs.getString(3));
					emp.setEmail(rs.getString(4));
					emp.setDob(rs.getString(5));
					emp.setGender(rs.getString(6));

					Department dep = new Department();
					dep.setId(rs.getLong(7));

					emp.setDep(dep);
				}

				return emp;
			}

		});
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		String sql = "update employee set first_name=?, last_name=?, email=?, dob=?, gender=?, dep_id=? where id=?";

		int count = getJdbcTemplate().update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, emp.getFirstName());
				ps.setString(2, emp.getLastName());
				ps.setString(3, emp.getEmail());
				ps.setString(4, emp.getDob());
				ps.setString(5, emp.getGender());
				ps.setLong(6, emp.getDep().getId());
				ps.setLong(7, emp.getId());

				return ps;
			}
		});

		if (count == 1) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteEmployee(Long id) {

		int count = getJdbcTemplate().update("delete from employee where id=" + id);

		if (count == 1) {
			return true;
		}

		return false;
	}

	@Override
	public List<Department> getDepartments() {
		return getJdbcTemplate().query("select * from department", new ResultSetExtractor<List<Department>>() {

			@Override
			public List<Department> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Department> depList = new ArrayList<>();

				while(rs.next()) {
					Department dep = new Department();
					dep.setId(rs.getLong(1));
					dep.setName(rs.getString(2));

					depList.add(dep);
				}

				return depList;
			}

		});
	}

}