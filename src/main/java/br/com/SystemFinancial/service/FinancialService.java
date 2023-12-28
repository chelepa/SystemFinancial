package br.com.SystemFinancial.service;

import br.com.SystemFinancial.dto.debt.DebitRequestDTO;
import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import br.com.SystemFinancial.dto.month.MonthRequestDTO;
import br.com.SystemFinancial.dto.month.MonthResponseDTO;

import java.util.List;

public interface FinancialService {
    DebitResponseDTO createdDebt(DebitRequestDTO request);
    void createdAllDebt(List<DebitRequestDTO> request);
    void deleteDebtById(Long id);
    DebitResponseDTO updateDebtById(Long id, DebitRequestDTO debt);
    DebitResponseDTO getDebt(Long id);
    MonthResponseDTO createdMonth(MonthRequestDTO request);

    MonthResponseDTO getMonthById(Long id);
}
