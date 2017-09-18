package com.hiberus.api.controller.rest.practice1;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pr1")
public class ControllerPr1 {

    public ControllerPr1() {
        System.out.println("ControllerPr1 constructed!");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity("Hello", HttpStatus.OK);
    }

}
