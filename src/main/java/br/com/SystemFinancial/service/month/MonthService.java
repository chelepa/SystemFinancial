package br.com.SystemFinancial.service.month;

import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import br.com.SystemFinancial.dto.month.MonthRequestDTO;
import br.com.SystemFinancial.dto.month.MonthResponseDTO;
import br.com.SystemFinancial.entity.MonthEntity;
import br.com.SystemFinancial.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class MonthService extends BaseService {

    @Autowired
    private ModelMapper modelMapper;

    public MonthResponseDTO createdMonth(MonthRequestDTO request) {
        log.info("MonthService.createdMonth - Start - MonthRequestDTO: [{}] ", request);
        var entity = modelMapper.map(request, MonthEntity.class);
        var save = this.saveMonth(entity);
        var response = modelMapper.map(save, MonthResponseDTO.class);
        log.info("MonthService.createdMonth - End - MonthResponseDTO: [{}] ", response);
        return response;
    }

    public MonthResponseDTO getMonthById(Long id) {
        log.info("MonthService.getMonthById - Start - Id_month: [{}] ", id);
        var entity = this.getMonth(id);
        var response = modelMapper.map(entity, MonthResponseDTO.class);
        var value_pag = response.getDebit().stream().filter(item -> item.getFlag_payment().equals(Boolean.TRUE)).map(DebitResponseDTO::getValue_debt).reduce(BigDecimal.ZERO, BigDecimal::add);
            response.setValue_pag(value_pag);
        var value_not_pag = response.getDebit().stream().filter(item -> item.getFlag_payment().equals(Boolean.FALSE)).map(DebitResponseDTO::getValue_debt).reduce(BigDecimal.ZERO, BigDecimal::add);
            response.setValue_not_pag(value_not_pag);
        log.info("MonthService.getMonthById - End - Response: [{}] ", response);
        return response;
    }
}
