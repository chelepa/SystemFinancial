CREATE TABLE IF NOT EXISTS table_month_debt (
  id_debt INT(11) NOT NULL,
  id_month INT(11) NOT NULL,
  PRIMARY KEY (id_debt, id_month),
  INDEX fk_table_month_debt_table_month1_idx (id_month ASC) VISIBLE,
  CONSTRAINT fk_table_month_debt_table_debt
    FOREIGN KEY (id_debt)
    REFERENCES u276960052_FinancialDEV.table_debt (id_debt)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_table_month_debt_table_month1
    FOREIGN KEY (id_month)
    REFERENCES u276960052_FinancialDEV.table_month (id_month)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)