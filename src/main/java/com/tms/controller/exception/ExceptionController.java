package com.tms.controller.exception;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public String handleRunTimeException(RuntimeException runtimeException, Model model) {
        model.addAttribute("exMessage", runtimeException.getMessage());
        return "Error";
    }
}
