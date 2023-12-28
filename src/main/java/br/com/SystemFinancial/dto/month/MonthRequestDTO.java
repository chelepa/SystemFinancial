package br.com.SystemFinancial.dto.month;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthRequestDTO {

    private Long id_month;
    private String nm_month;
    private Long id_year;
}
