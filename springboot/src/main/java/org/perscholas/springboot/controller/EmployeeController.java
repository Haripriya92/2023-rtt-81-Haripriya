package org.perscholas.springboot.controller;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDao;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.perscholas.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Slf4j
@Controller
public class EmployeeController {
@Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeService employeeService;
@GetMapping("/employee/create")
    public ModelAndView createEmployee(@RequestParam(required=false) String firstname,@RequestParam(required=false) String lastname,
                                       @RequestParam(required=false) String phonenumber,@RequestParam(required=false) String city){

    ModelAndView response=new ModelAndView("employee/e_register");
    return response;

}
    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(CreateEmployeeFormBean form) {
        ModelAndView response=new ModelAndView("employee/e_register");
        employeeService.createEmployee(form);
        log.info("In create employee with incoming args");

        return response;
    }
    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String firstNameSearch,
                               @RequestParam(required = false) String lastNameSearch) {
        ModelAndView response = new ModelAndView("employee/e_search");

        log.debug("in the employee search controller method : first name = " + firstNameSearch + " last name = " + lastNameSearch);

        if (!StringUtils.isEmpty(firstNameSearch) || !StringUtils.isEmpty(lastNameSearch)) {

            response.addObject("firstNameSearch", firstNameSearch);
            response.addObject("lastNameSearch", lastNameSearch);

            if (!StringUtils.isEmpty(firstNameSearch)) {
                firstNameSearch = "%" + firstNameSearch + "%";
            }

            if (!StringUtils.isEmpty(lastNameSearch)) {
                lastNameSearch = "%" + lastNameSearch + "%";
            }

            // we only want to do this code if the user has entered either a first name or a last name
            List<Employee> employees = employeeDao.findByFirstNameOrLastName(firstNameSearch, lastNameSearch);

            response.addObject("employeeVar", employees);


            for (Employee employee : employees) {
                log.debug("customer: id = " + employee.getId() + " last name = " + employee.getLastName());
            }
        }

        return response;
    }
    @GetMapping("/employee/edit/{employeeId}")
    public ModelAndView editCustomer(@PathVariable int employeeId) {
        ModelAndView response = new ModelAndView("employee/e_register");

        Employee employee = employeeDao.findById(employeeId);

        CreateEmployeeFormBean form = new CreateEmployeeFormBean();

        if ( employee != null ) {
            form.setId(employee.getId());
            form.setFirstname(employee.getFirstName());
            form.setLastname(employee.getLastName());
            form.setPhonenumber(employee.getPhone());
            form.setCity(employee.getCity());
        } else {
            log.warn("Customer with id " + employeeId + " was not found") ;
        }

        response.addObject("form", form);

        return response;

    }

}
