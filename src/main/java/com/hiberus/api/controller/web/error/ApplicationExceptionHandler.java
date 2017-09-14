package com.hiberus.api.controller.web.error;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Daniel Pardo Ligorred.
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

    /**
     * Default handler for any exception across the entire application.
     *
     * @param httpServletRequest
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {
            NullPointerException.class,
            AuthenticationCredentialsNotFoundException.class})
    public ModelAndView exception(HttpServletRequest httpServletRequest, Exception exception) {

        ModelAndView modelAndView = new ModelAndView("error/general");

        modelAndView.addObject("url", httpServletRequest.getRequestURL());
        modelAndView.addObject("errorMessage", exception.getClass() + ((exception.getMessage() != null) ? exception.getMessage() : "Unknown"));

        return modelAndView;
    }

}