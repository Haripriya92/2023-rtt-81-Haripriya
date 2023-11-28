package org.perscholas.springboot.controller;

import org.perscholas.springboot.database.dao.EmployeeDao;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
@Autowired
    private EmployeeDao employeeDao;

@GetMapping("/employeeRegister")
    public ModelAndView createEmployee(@RequestParam String firstname,@RequestParam String lastname,
                                       @RequestParam String phonenumber,@RequestParam String city){

    ModelAndView response=new ModelAndView("customer/e_register.jsp");
    return response;

}
    @GetMapping("customer/createSubmit")
    public ModelAndView createCustomerSubmit(CreateEmployeeFormBean form) {
        ModelAndView response=new ModelAndView("/employeeRegister");
        Employee employee = new Employee();
        employee.setFirstName(form.getFirstname());
        employee.setLastName(form.getLastname());
        employee.setPhone(form.getPhonenumber());
        employee.setCity(form.getCity());

        employeeDao.save(employee);

        return response;
    }
}
