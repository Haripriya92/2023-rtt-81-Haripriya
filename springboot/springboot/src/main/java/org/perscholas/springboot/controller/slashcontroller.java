package org.perscholas.springboot.controller;

import org.perscholas.springboot.database.entity.User;
import org.springframework.stereotype.Controller;

@Controller
public class slashcontroller {
    public void setIndex() {
        User user = new User();
        user.setId(1);
    }
}
