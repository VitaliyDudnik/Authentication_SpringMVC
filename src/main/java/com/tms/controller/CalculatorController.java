package com.tms.controller;

import com.tms.entity.Operation;
import com.tms.entity.User;
import com.tms.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@SessionAttributes("user")
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalcService calcService;

    public CalculatorController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/calc")
    public String calcGet() {
        return "Calc";
    }

    @PostMapping("/calc")
    public String calcPost(double num1, double num2, String operation, Model model) {

            User user = (User) model.getAttribute("user");
            try {
                calcService.calcHistory(num1, num2, operation, LocalDate.now(), user);
                double result = calcService.calculation(num1, num2, operation);
                model.addAttribute("result", "Result: " + result);
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
            }
        return "Calc";
    }

    @GetMapping("/history")
    public String historyGet(Model model) {
        try {
            User user = (User) model.getAttribute("user");
            List<Operation> operationList = calcService.getAll();
            List<Operation> historyList = operationList.stream()
                    .filter(o -> o.getUser().getUsername().equals(user.getUsername()))
                    .collect(Collectors.toList());
            model.addAttribute("calcHistory", historyList);
            return "CalcHistory";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "CalcHistory";
    }
}

