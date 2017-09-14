package com.hiberus.api.controller.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Controller
@RequestMapping("/error")
public class CustomErrorController {

    @RequestMapping("/generalError")
    public String generalError(HttpServletRequest request, HttpServletResponse response, Model model) {

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

        String exceptionMessage = getExceptionMessage(throwable, statusCode);

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

        if (requestUri == null) requestUri = "Unknown";

        String message = MessageFormat.format(
                "{0} returned for {1} with message {2}",
                statusCode, requestUri, exceptionMessage);

        model.addAttribute("errorMessage", message);

        return "error/general";
    }

    private String getExceptionMessage(Throwable throwable, Integer statusCode) {

        if (throwable != null) return (throwable.getMessage() != null) ? throwable.getMessage() : "Unknown";

        return HttpStatus.valueOf(statusCode).getReasonPhrase();
    }

}