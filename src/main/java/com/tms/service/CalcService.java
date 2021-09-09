package com.tms.service;

import com.tms.calculator.CalcOperation;
import com.tms.calculator.operators.OperatorMap;
import com.tms.dao.HibernateOperationDao;
import com.tms.entity.Operation;
import com.tms.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class CalcService {

    private final HibernateOperationDao hibernateOperationDao;

    public CalcService(HibernateOperationDao hibernateOperationDao) {
        this.hibernateOperationDao = hibernateOperationDao;
    }

    public List<Operation> getAll() {
        return hibernateOperationDao.getAll();
    }

    public void calcHistory(double num1, double num2, String operation, LocalDate localDate, User user) {
        switch (operation) {
            case "sum":
                Operation sum = new Operation(num1, num2, num1 + num2, operation, localDate, user);
                hibernateOperationDao.save(sum);
                break;
            case "sub":
                Operation subtraction = new Operation(num1, num2, num1 - num2, operation, localDate, user);
                hibernateOperationDao.save(subtraction);
                break;
            case "mul":
                Operation multiplication = new Operation(num1, num2, num1 * num2, operation, localDate, user);
                hibernateOperationDao.save(multiplication);
                break;
            case "div":
                if (num2 != 0) {
                    Operation division = new Operation(num1, num2, num1 / num2, operation, localDate, user);
                    hibernateOperationDao.save(division);
                } else {
                    break;
                }
        }
    }

    public double calculation(double number1, double number2, String operation) {
        Map<String, CalcOperation> operationMap = OperatorMap.addOperatorsToMap();
        CalcOperation calcOperationMapValue = operationMap.get(operation);
        return calcOperationMapValue.calculate(number1, number2);
    }

}
