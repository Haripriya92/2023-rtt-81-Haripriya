package org.perscholas.springboot.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeFormBean {
    private Integer id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String city;
}
