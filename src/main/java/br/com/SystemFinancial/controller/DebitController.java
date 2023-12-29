package br.com.SystemFinancial.controller;

import br.com.SystemFinancial.dto.debt.DebitRequestDTO;
import br.com.SystemFinancial.dto.debt.DebitResponseDTO;
import br.com.SystemFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DebitController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/register/debt")
    public ResponseEntity<DebitResponseDTO> createdDebt(@RequestBody DebitRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createdDebt(request));
    }

    @PostMapping(value = "/v1/register/all/debt")
    public ResponseEntity<Void> createdAllDebt(@RequestBody List<DebitRequestDTO> request){
        service.createdAllDebt(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/v1/debt/{id}")
    public ResponseEntity<DebitResponseDTO> getDebtById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getDebt(id));
    }

    @DeleteMapping(value = "/v1/debt/{id}")
    public ResponseEntity<Void> deleteDebtById(@PathVariable("id") Long id) {
        service.deleteDebtById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping(value = "/v1/debt/{id}")
    public ResponseEntity<DebitResponseDTO> updateDebt(@PathVariable("id") Long id, @RequestBody DebitRequestDTO debt){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateDebtById(id, debt));
    }

}
