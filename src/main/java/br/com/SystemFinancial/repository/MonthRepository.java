package br.com.SystemFinancial.repository;

import br.com.SystemFinancial.entity.MonthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<MonthEntity, Long> {

}
