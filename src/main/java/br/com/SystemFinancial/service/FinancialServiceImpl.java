package br.com.SystemFinancial.service;

import br.com.SystemFinancial.dto.debt.DebitRequestDTO;
import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import br.com.SystemFinancial.dto.month.MonthRequestDTO;
import br.com.SystemFinancial.dto.month.MonthResponseDTO;
import br.com.SystemFinancial.service.debt.DebtService;
import br.com.SystemFinancial.service.month.MonthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private DebtService debtService;

    @Autowired
    private MonthService monthService;

    @Override
    public DebitResponseDTO createdDebt(DebitRequestDTO request) {
        return debtService.createdDebt(request);
    }

    @Override
    public void createdAllDebt(List<DebitRequestDTO> request) {
        debtService.createdAllDebt(request);
    }

    @Override
    public void deleteDebtById(Long id) {
        debtService.deleteDeb(id);
    }

    @Override
    public DebitResponseDTO updateDebtById(Long id, DebitRequestDTO debt) {
        return debtService.updateDebtById(id, debt);
    }

    @Override
    public DebitResponseDTO getDebt(Long id) {
        return debtService.searchDebitById(id);
    }

    @Override
    public MonthResponseDTO createdMonth(MonthRequestDTO request) {
        return monthService.createdMonth(request);
    }
    @Override
    public MonthResponseDTO getMonthById(Long id) {
        return monthService.getMonthById(id);
    }

    @Override
    public List<MonthResponseDTO> getAllMonth() {
        return monthService.getAllMonth();
    }
}
