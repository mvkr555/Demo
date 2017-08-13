/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijay.spring.service;

import com.vijay.spring.model.Employee;
import java.util.List;

/**
 *
 * @author mvkr
 */
public interface EmployeeService {
    
    /**
     * This method is used to add the employee details.
     * 
     * @param employee - this parameter contains employee information.
     */
    public void addEmployee(Employee employee);

    /**
     * This method is used to update the employee details.
     * 
     * @param employee - this parameter contains employee information.
     */
    public void updateEmployee(Employee employee);

    /**
     * This method is used to add the employee details.
     * 
     * @return as list of employee details.
     */
    public List<Employee> listEmployee();

    /**
     * This method is used to add the employee details.
     * 
     * @param id - this parameter contains employee id.
     * @return as employee information.
     */
    public List<Employee> getEmployeeById(int id);

    /**
     * This method is used to remove the employee details.
     *
     * @param id - this parameter contains employee id.
     */
    public void removeEmployee(int id);
}
