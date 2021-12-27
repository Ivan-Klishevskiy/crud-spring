package by.tms.crudspring.controller;

import by.tms.crudspring.dto.CalculatorDto;
import by.tms.crudspring.service.CalcService;
import by.tms.crudspring.service.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;
    private final OperationService operationService;

    public CalcController(CalcService calcService, OperationService operationService) {
        this.calcService = calcService;
        this.operationService = operationService;
    }

    @GetMapping
    public String calculator(Model model) {
        model.addAttribute("calcModel",new CalculatorDto());
        return "simpleCalc";
    }

    @PostMapping
    public String simple(CalculatorDto calculatorDto, Model model, HttpSession httpSession) {
        calculatorDto.setResult(calcService.calculate((String) httpSession.getAttribute("user"),
                calculatorDto.getFirst(), calculatorDto.getSecond(), calculatorDto.getSign()));
        model.addAttribute("calcModel",calculatorDto);
        model.addAttribute("resultValue",calculatorDto.getResult());
        model.addAttribute("history", operationService.getAllHistory((String) httpSession.getAttribute("user")));
        return "simpleCalc";
    }
}
