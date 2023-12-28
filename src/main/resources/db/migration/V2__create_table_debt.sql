CREATE TABLE IF NOT EXISTS table_debt (
    id_debt INT(11) NOT NULL AUTO_INCREMENT,
    nm_debt VARCHAR(45) NOT NULL,
    vl_debt DECIMAL(10,2) NOT NULL,
    flag_payment TINYINT(1) NULL DEFAULT NULL,
    PRIMARY KEY (id_debt)
)