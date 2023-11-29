package org.perscholas.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDao;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @GetMapping("customer/create")
    public ModelAndView createCustomer(@RequestParam(required=false)String firstname,
                                       @RequestParam(required=false)String lastname,
    @RequestParam(required=false)String phone,@RequestParam(required=false)String city){
        ModelAndView response=new ModelAndView("customer/create");
        System.out.println("firstname: "+firstname);
        System.out.println("lastname: "+lastname);
        System.out.println("phone: "+phone);
        System.out.println("city: "+city);
         return response;
    }
    // the action attribute on the form tag is set to /customer/createSubmit so this method will be called when the user clicks the submit button
    @GetMapping("customer/createSubmit")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean form) {
        ModelAndView response=new ModelAndView("customer/create");

        log.info("firstName: " + form.getFirstname());
        log.info("lastName: " + form.getLastname());
        log.info("phone: " + form.getPhone());
        log.info("city: " + form.getCity());
        Customer customer = new Customer();
        customer.setFirstName(form.getFirstname());
        customer.setLastName(form.getLastname());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());

        customerDao.save(customer);

        log.info("In create customer with incoming args");

        return response;
    }

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("customer/search");
        log.info("In the customer search controller method:search parameter:"+search);
        if(search!=null)
        {
            List<Customer> customers=customerDao.findByFirstName(search);
            response.addObject("customerVar", customers);
            response.addObject("search", search);
            for (Customer customer :customers)
            {
                log.info("customer: id "+customer.getId()+" First Name "+customer.getFirstName()+" Last Name "+customer.getLastName());
                log.info("customer: Phone "+customer.getPhone()+" City "+customer.getCity());
            }
        }
        return response;
    }
}
