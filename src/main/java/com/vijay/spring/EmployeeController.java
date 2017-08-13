package com.vijay.spring;

import com.vijay.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vijay.spring.service.EmployeeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	
        private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    
        private EmployeeService employeeService;
	
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
        
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		
		return "employee";
	}
	
	//For add and update person both

	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public @ResponseBody String addEmployee(@RequestBody Employee employee){
		log.info("enter addEmployee method.");
                try{
                log.info("enter addEmployee method."+employee);
		if(employee.getId() == 0){
			//new employee, add it
                        this.employeeService.addEmployee(employee);
		}else{
			//existing employee, call update
                        this.employeeService.updateEmployee(employee);
			
		}
                }catch(Exception e){
                    return "fail";
                }
		log.info("End addEmployee method.");
		return "success";
		
	}
        
        @RequestMapping(value= "/employeeTable", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployeeList(Model model){
		log.info("enter getEmployeeList method.");
                return this.employeeService.listEmployee();
	}
	
    @RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
    public @ResponseBody 
        String deleteEmployee(@PathVariable("id") int id){
	try{	
        this.employeeService.removeEmployee(id);
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
 
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
    public @ResponseBody 
        List<Employee> updateEmployee(@PathVariable("id") int id, Model model){
            log.info("enter edit method"); 
        
          return this.employeeService.getEmployeeById(id);  
       
    }
	
}
