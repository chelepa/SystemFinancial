package br.com.SystemFinancial.dto.debt;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DebitResponseDTO {

    private Long id;
    private String name_debt;
    private BigDecimal value_debt;
    private Boolean flag_payment;

}