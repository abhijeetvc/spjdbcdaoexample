package com.spjdbc.spjdbcdaoexample.dao;

import com.spjdbc.spjdbcdaoexample.model.Employee;
import com.spjdbc.spjdbcdaoexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public String saveEmployee(Employee employee) {
        String sql="insert into employee(name,city) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getName(),employee.getCity()});
        return "Employee saved";
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql="select * from employee where id=?";
        Employee employee=jdbcTemplate.queryForObject(sql,new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(Employee.class));

        return employee;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql="update employee set name=?,city=? where id=?";
        int status=jdbcTemplate.update(sql,new Object[]{employee.getName(),employee.getCity(),employee.getId()});
        System.out.println("Status: "+status);
        if(status==0){
            return "Record not found";
        }
        return "Employee updated";
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql="delete from employee where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "Employee deleted";
    }

    @Override
    public List<Map<String, Object>> getCombinedData() {
        String sql="select a.id,a.name,a.city,b.name as deptName from employee a,department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }


}
