package com.hiberus.api.controller.web;

import com.hiberus.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

        model.addAttribute("title", "Customers");
        model.addAttribute("customers", this.customerService.getAll());

        return "customers";
    }

    @RequestMapping(value = "/all2", method = RequestMethod.GET)
    public ModelAndView getAll() throws Exception {

        ModelAndView model = new ModelAndView("customers");
        model.addObject("title", "Customers 2");
        model.addObject("customers", this.customerService.getAll());

        return model;
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String throwException() throws Exception {

        throw new NullPointerException("Throwing exception...");
    }

}