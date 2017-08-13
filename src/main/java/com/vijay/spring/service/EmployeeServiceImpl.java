/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijay.spring.service;

import com.vijay.spring.dao.EmployeeDAO;
import com.vijay.spring.model.Employee;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mvkr
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    
  
    private EmployeeDAO employeeDAO;
    
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public List<Employee> listEmployee() {
        return this.employeeDAO.listEmployee();
    }

    @Override
    @Transactional
    public List<Employee> getEmployeeById(int id) {
       return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        this.employeeDAO.removeEmployee(id);
    }
    
}
