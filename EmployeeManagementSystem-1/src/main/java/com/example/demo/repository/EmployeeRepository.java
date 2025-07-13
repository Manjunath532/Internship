package com.example.demo.repository;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;



@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> employeeMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee e = new Employee();
            e.setId(rs.getInt("empid"));
            e.setName(rs.getString("empname"));
            e.setDepartment(rs.getString("empdepartment"));
            e.setPosition(rs.getString("position"));
            e.setSalary(rs.getDouble("salary"));
            return e;
        }
    };

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, employeeMapper);
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE empid=?", employeeMapper, id);
    }

    public void save(Employee emp) {
        jdbcTemplate.update("INSERT INTO employee(empname, empdepartment, position, salary) VALUES (?, ?, ?, ?)",
                emp.getName(), emp.getDepartment(), emp.getPosition(), emp.getSalary());
    }

    public void update(int id, Employee emp) {
        jdbcTemplate.update("UPDATE employee SET empname=?, empdepartment=?, position=?, salary=? WHERE empid=?",
                emp.getName(), emp.getDepartment(), emp.getPosition(), emp.getSalary(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM employee WHERE empid=?", id);
    }
}