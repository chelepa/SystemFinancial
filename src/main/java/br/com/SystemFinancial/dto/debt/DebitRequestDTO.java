package br.com.SystemFinancial.dto.debt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebitRequestDTO {
    private String name_debt;
    private BigDecimal value_debt;
    private Boolean flag_payment;
    private Long id_month;
}