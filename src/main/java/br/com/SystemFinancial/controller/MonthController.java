package br.com.SystemFinancial.controller;

import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import br.com.SystemFinancial.dto.month.MonthRequestDTO;
import br.com.SystemFinancial.dto.month.MonthResponseDTO;
import br.com.SystemFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonthController {
    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/register/month")
    public ResponseEntity<MonthResponseDTO> createdMonth(@RequestBody MonthRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createdMonth(request));
    }

    @GetMapping(value = "/v1/month/{id}")
    public ResponseEntity<MonthResponseDTO> getMonthById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getMonthById(id));
    }

    @GetMapping(value = "/v1/month")
    public ResponseEntity<List<MonthResponseDTO>> getMonth(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllMonth());
    }
}
