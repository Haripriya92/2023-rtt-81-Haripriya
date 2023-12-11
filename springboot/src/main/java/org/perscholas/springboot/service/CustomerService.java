package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDao;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public Customer createCustomer(CreateCustomerFormBean form) {
        log.debug("id: " + form.getId());
        log.debug("firstName: " + form.getFirstname());
        log.info("lastName: " + form.getLastname());
        log.info("phone: " + form.getPhone());
        log.info("city: " + form.getCity());

        Customer customer = customerDao.findById(form.getId());


        if ( customer == null ) {
            customer = new Customer();
            /**
             * Add the user name for which the cart item is added
             */
            User user = authenticatedUserService.loadCurrentUser();
            customer.setUserId(user.getId());
        }

        // set the incoming values to be save to the database
        customer.setFirstName(form.getFirstname());
        customer.setLastName(form.getLastname());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());
        customer.setImageUrl(form.getImageUrl());
       return customerDao.save(customer);
    }
}
