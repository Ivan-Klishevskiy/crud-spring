package by.tms.crudspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDto {

    private double first;

    private String sign;

    private double second;

    private double result;
}
