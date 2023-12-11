package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateCustomerFormBean {
    private Integer id;

    @NotEmpty(message = "First Name is required.")
    @Length(max = 45, message = "First Name must be less than 45 characters.")
    private String firstname;


    @NotEmpty(message = "Last Name is required.")
    @Length(max = 45, message = "Last Name must be less than 45 characters.")
    private String lastname;

    @NotEmpty(message = "Last Name is required.")
    @Length(max = 45, message = "phone number must be less than 45 characters.")
    private String phone;

    @NotEmpty(message = "City is required.")
    @Length(max = 45, message = "City must be less than 45 characters.")
    private String city;

    @NotEmpty(message = "Image is required.")
    private String imageUrl;
}
