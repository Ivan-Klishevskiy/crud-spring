package by.tms.crudspring.service;

import by.tms.crudspring.entity.Calculator;
import org.springframework.stereotype.Component;

@Component
public class CalcService {
    private final OperationService operationService;

    public CalcService(OperationService operationService) {
        this.operationService = operationService;
    }

    public double calculate(String username , double first, double second, String sign) {
        double result = 0;
        switch (sign) {
            case "+" : {
                result = Calculator.sum(first, second);
                break;
            }
            case "-" : {
                result = Calculator.sub(first, second);
                break;
            }
            case "/" : {
                result = Calculator.div(first, second);
                break;
            }
            case "*" : {
                result = Calculator.mul(first, second);
                break;
            }
            default : result = 0;
        }
        operationService.addOperation(username, String.format("%.2f %s %.2f = %.2f", first, sign, second, result));
        return result;
    }
}
