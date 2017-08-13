/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijay.spring.service;


import com.vijay.spring.model.Employee;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author mvkr
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {
    
    public EmployeeServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addEmployee method, of class EmployeeServiceImpl.
     */
    @Test
    @Ignore
    public void testAddEmployee() {
        System.out.println("addEmployee");
        Employee employee = new Employee();
        employee.setAddress("1/2 chennai");
        employee.setEmail("vv@mm.com");
        employee.setAge(25);
        employee.setPhoneNumber("8939079899");
        employee.setName("vijay");
        
        EmployeeServiceImpl instance = new EmployeeServiceImpl();
        instance.addEmployee(employee);
        
    }

    /**
     * Test of updateEmployee method, of class EmployeeServiceImpl.
     */
    @Test
    @Ignore
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        Employee employee = new Employee();
        employee.setAddress("1/2 chennai");
        employee.setEmail("vv@mm.com");
        employee.setAge(25);
        employee.setPhoneNumber("8939079899");
        employee.setName("vijay");
        employee.setId(3); 
        
        EmployeeServiceImpl instance = new EmployeeServiceImpl();
        instance.updateEmployee(employee);
       }

    /**
     * Test of listEmployee method, of class EmployeeServiceImpl.
     */
    @Test
    @Ignore
    public void testListEmployee() {
        System.out.println("listEmployee");
        EmployeeServiceImpl instance = new EmployeeServiceImpl();
        List<Employee> result = instance.listEmployee();
        assertTrue(result.size() > 0); 
        
    }

    /**
     * Test of getEmployeeById method, of class EmployeeServiceImpl.
     */
    @Test
    @Ignore
    public void testGetEmployeeById() {
        System.out.println("getEmployeeById");
        int id = 4;
        EmployeeServiceImpl instance = new EmployeeServiceImpl();
        List<Employee> result = instance.getEmployeeById(id);
        assertTrue(result.size() == 1); 
    }

    /**
     * Test of removeEmployee method, of class EmployeeServiceImpl.
     */
    @Test
    @Ignore
    public void testRemoveEmployee() {
        System.out.println("removeEmployee");
        int id = 4;
        EmployeeServiceImpl instance = new EmployeeServiceImpl();
        instance.removeEmployee(id);
        
    }
    
}
