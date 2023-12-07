package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDao;
import org.perscholas.springboot.database.dao.EmployeeDao;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    public void createEmployee(CreateEmployeeFormBean form) {
        log.debug("id: " + form.getId());
        log.debug("firstName: " + form.getFirstname());
        log.info("lastName: " + form.getLastname());
        log.info("phone: " + form.getPhonenumber());
        log.info("city: " + form.getCity());

        Employee employee = employeeDao.findById(form.getId());


        if ( employee == null ) {
            employee = new Employee();
        }

        // set the incoming values to be save to the database
        employee.setFirstName(form.getFirstname());
        employee.setLastName(form.getLastname());
        employee.setPhone(form.getPhonenumber());
        employee.setCity(form.getCity());

        employeeDao.save(employee);
    }
}
