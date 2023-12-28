package br.com.SystemFinancial.service.debt;

import br.com.SystemFinancial.dto.debt.DebitRequestDTO;
import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import br.com.SystemFinancial.entity.DebtEntity;
import br.com.SystemFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DebtService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public DebitResponseDTO createdDebt(DebitRequestDTO request) {
        log.info("DebtService.createdDebt - Start - DebitRequestDTO: [{}] ", request);
        var entity = modelMapper.map(request, DebtEntity.class);
        var month = this.getMonth(request.getId_month());
            entity.setMonth(List.of(month));
        var save = this.saveDebt(entity);
        var response = modelMapper.map(save, DebitResponseDTO.class);
        log.info("DebtService.createdDebt - END - Response: [{}] ", response);
        return response;
    }

    public void createdAllDebt(List<DebitRequestDTO> request) {
        log.info("DebtService.createdAllDebt - Start - DebitRequestDTO: [{}] ", request);
        request.forEach(this::createdDebt);
        log.info("DebtService.createdAllDebt - END ");
    }

    public DebitResponseDTO searchDebitById(Long id) {
        log.info("DebtService.searchDebitById - Start - Id: [{}] ", id);
        var debt = this.getDebtById(id);
        var response = modelMapper.map(debt, DebitResponseDTO.class);
        log.info("DebtService.searchDebitById - End - Response: [{}] ", response);
        return response;
    }

    public void deleteDeb(Long id) {
        log.info("DebtService.deleteDebtById - Start - Id: [{}] ", id);
        this.deleteDebtById(id);
        log.info("DebtService.deleteDebtById - End - Id: [{}] - Deleted", id);
    }

    public DebitResponseDTO updateDebtById(Long id, DebitRequestDTO debt) {
        log.info("DebtService.updateDebtById - start - Id: [{}] DebitRequestDTO: [{}]", id, debt);
        var entity = this.getDebtById(id);
        modelMapper.map(debt, entity);
        var save = this.saveDebt(entity);
        var response = modelMapper.map(save, DebitResponseDTO.class);
        log.info("DebtService.updateDebtById - End - Id: [{}] Response: [{}]", id, response);
        return response;
    }
}
