package br.com.SystemFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "table_debt")
public class DebtEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_debt")
    private Long id_debt;

    @Column(name = "nm_debt")
    private String name_debt;

    @Column(name = "vl_debt")
    private BigDecimal value_debt;

    @Column(name = "flag_payment")
    private Boolean flag_payment;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "table_month_debt",
            joinColumns = @JoinColumn(name = "id_debt", referencedColumnName = "id_debt"),
            inverseJoinColumns = @JoinColumn(name = "id_month", referencedColumnName = "id_month")
    )
    private List<MonthEntity> month = new ArrayList<>();
}
