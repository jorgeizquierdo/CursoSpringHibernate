package com.hiberus.api.controller.web;

import com.hiberus.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Controller("webCustomerController")
@RequestMapping("/customer")
public class WebCustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Model model) throws Exception {

        model.addAttribute("customers", this.customerService.getAll());

        return "customers";
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String throwException() throws Exception {

        throw new Exception("Throwing exception...");
    }

}