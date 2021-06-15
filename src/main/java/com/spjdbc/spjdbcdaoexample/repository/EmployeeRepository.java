package com.spjdbc.spjdbcdaoexample.repository;

import com.spjdbc.spjdbcdaoexample.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    String saveEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    String updateEmployee(Employee employee);

    String deleteEmployee(Integer id);

    List<Map<String,Object>> getCombinedData();
}
