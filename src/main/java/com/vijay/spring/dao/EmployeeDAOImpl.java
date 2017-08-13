/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijay.spring.dao;

import com.vijay.spring.model.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mvkr
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    
    private static final Logger log = LoggerFactory.getLogger(EmployeeDAOImpl.class);
    
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory factory){
            this.sessionFactory = factory;
    }

    @Override
    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
      
	log.info("Employee details saved successfully, Employee Details="+employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
       Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
        log.info("Employee details updated successfully, Employee Details="+employee);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> listEmployee() {
       Session session = this.sessionFactory.getCurrentSession();
       Criteria criteria = session.createCriteria(Employee.class);
       List<Employee> employeeList = criteria.list();
       log.info("Employee list size : "+employeeList.size()); 
       if(employeeList.size()== 0){
           Employee temp = new Employee();
           temp.setId(0);
           employeeList.add(temp);
           log.info("Employee temp data " +temp); 
       }
        return employeeList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getEmployeeById(int id) {
       Session session = this.sessionFactory.getCurrentSession();
       
         Criteria criteria = session.createCriteria(Employee.class);
         criteria.add(Restrictions.eq("id",id));
       List<Employee> employeeList = criteria.list();
       log.info("Employee list size : "+employeeList.size()); 
       if(employeeList.size()== 0){
           Employee temp = new Employee();
           temp.setId(0);
           employeeList.add(temp);
           log.info("Employee temp data " +temp); 
       }
       
       log.info("Employee loaded successfully, Employee details="+employeeList);
        return employeeList;
      
    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        if(null != employee){
                session.delete(employee);
        }
       
        log.info("Employee deleted successfully, Employee details="+employee);
        
    }
    
}
