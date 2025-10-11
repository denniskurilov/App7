package com.denniskurilov.app7.api;

import com.denniskurilov.app7.entity.Employee;
import com.denniskurilov.app7.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeAPI {
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeAPI(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        checkEmployee(employee, id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        checkEmployee(employee, id);
        employeeService.delete(employee);
        return employee;
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable Integer id, @RequestBody Map<String, Object> patchEmployee) {
        Employee employee = employeeService.findById(id);
        checkEmployee(employee, id);
        Employee updatedEmployee = apply(patchEmployee, employee);
        updatedEmployee.setId(id);
        return employeeService.save(updatedEmployee);
    }

    private Employee apply(Map<String, Object> patchEmployee, Employee employee) {
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
        ObjectNode pathNode = objectMapper.convertValue(patchEmployee, ObjectNode.class);
        employeeNode.setAll(pathNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    private void checkEmployee(Employee employee, Integer id){
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Employee id (" + id + ") not found");
        }
    }

}
