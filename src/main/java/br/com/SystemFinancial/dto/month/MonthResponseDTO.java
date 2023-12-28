package br.com.SystemFinancial.dto.month;

import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class MonthResponseDTO {

    private Long id_month;
    private String nm_month;
    private Long id_year;
    private BigDecimal value_pag;
    private BigDecimal value_not_pag;
    private List<DebitResponseDTO> debit;
}
