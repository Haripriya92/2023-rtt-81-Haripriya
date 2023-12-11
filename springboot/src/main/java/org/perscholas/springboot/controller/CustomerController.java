package org.perscholas.springboot.controller;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDao;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @GetMapping("/customer/create")
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
    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(@Valid  CreateCustomerFormBean form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit - has errors #########################");
            ModelAndView response = new ModelAndView("customer/create");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }
        Customer c=customerService.createCustomer(form);
        ModelAndView response=new ModelAndView();
        response.setViewName("redirect:/customer/edit/" + c.getId() + "?success=Customer Saved Successfully");
        log.info("In create customer with incoming args");

        return response;
    }
    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstNameSearch,
                               @RequestParam(required = false) String lastNameSearch) {
        ModelAndView response = new ModelAndView("customer/search");

        log.debug("in the customer search controller method : first name = " + firstNameSearch + " last name = " + lastNameSearch);

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
            List<Customer> customers = customerDao.findByFirstNameOrLastName(firstNameSearch, lastNameSearch);

            response.addObject("customerVar", customers);


            for (Customer customer : customers) {
                log.debug("customer: id = " + customer.getId() + " last name = " + customer.getLastName());
            }
        }

        return response;
    }
    @GetMapping("/customer/edit/{customerId}")
    public ModelAndView editCustomer(@PathVariable int customerId,
                                     @RequestParam(required = false) String success) {
        ModelAndView response = new ModelAndView("customer/create");

        Customer customer = customerDao.findById(customerId);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }
        CreateCustomerFormBean form = new CreateCustomerFormBean();

        if ( customer != null ) {
            form.setId(customer.getId());
            form.setFirstname(customer.getFirstName());
            form.setLastname(customer.getLastName());
            form.setPhone(customer.getPhone());
            form.setCity(customer.getCity());
            form.setImageUrl(customer.getImageUrl());
        } else {
            log.warn("Customer with id " + customerId + " was not found") ;
        }

        response.addObject("form", form);

        return response;

    }
    @GetMapping("/customer/myCustomers")
    public void myCustomers() {
        log.info("######################### In my customers #########################");

        // 1) Use the authenticated user service to find the logged in user
        User user = authenticatedUserService.loadCurrentUser();

        // 2) Create a DAO method that will find by userId
        // 3) use the authenticated user id to find a list of all customers created by this user
        List<Customer> customers = customerDao.findByUserId(user.getId());

        // 4) loop over the customers created and log.debug the customer id and customer last name
        for ( Customer customer : customers ) {
            log.debug("customer: id = " + customer.getId() + " last name = " + customer.getLastName());
        }

    }

}

