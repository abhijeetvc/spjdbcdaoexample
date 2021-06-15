package com.spjdbc.spjdbcdaoexample.controller;

import com.spjdbc.spjdbcdaoexample.dao.EmployeeDao;
import com.spjdbc.spjdbcdaoexample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getallemployees")
    public List<Employee> saveEmployee(){
        return employeeDao.getAllEmployees();
    }

    @PostMapping("/saveEmp")
    public String saveEmpl(@RequestBody Employee employee){
        return employeeDao.saveEmployee(employee);
    }


    @GetMapping("/getempbyid/{id}")
    public Employee getEmpById(@PathVariable Integer id){
        return employeeDao.getEmployeeById(id);
    }

    @PutMapping("/updateEmp")
    public String updateEmp(@RequestBody Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }

    @GetMapping("/getcombineddata")
    public List<Map<String,Object>> getJoinData(){
        return employeeDao.getCombinedData();
    }
}

// curl