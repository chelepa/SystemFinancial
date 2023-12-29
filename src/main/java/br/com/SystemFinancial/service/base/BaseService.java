package br.com.SystemFinancial.service.base;

import br.com.SystemFinancial.entity.DebtEntity;
import br.com.SystemFinancial.entity.MonthEntity;
import br.com.SystemFinancial.exceptions.NotFoundException;
import br.com.SystemFinancial.repository.DebtRepository;
import br.com.SystemFinancial.repository.MonthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BaseService {

    @Autowired
    private DebtRepository debtRepository;

    @Autowired
    private MonthRepository monthRepository;

//    --------------- Debt ------------------
    protected DebtEntity saveDebt(DebtEntity entity) {
        return debtRepository.save(entity);
    }

    protected DebtEntity getDebtById(Long id) {
        return debtRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Debt Not Found - Id: [%s] ", id)));
    }

    protected void deleteDebtById(Long id) {
        debtRepository.deleteById(id);
    }

//    --------------- Debt ------------------

    protected MonthEntity saveMonth(MonthEntity entity) {
        return monthRepository.save(entity);
    }

    protected MonthEntity getMonth(Long id) {
        return monthRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Month Not Found - Id: [%s] ", id)));
    }

    protected List<MonthEntity> getMonthFindAll() {
        return monthRepository.findAll();
    }
}
