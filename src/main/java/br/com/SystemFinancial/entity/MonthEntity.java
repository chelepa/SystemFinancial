package br.com.SystemFinancial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "table_month")
public class MonthEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_month")
    private Long id_month;

    @Column(name = "id_year")
    private Long id_year;

    @Column(name = "nm_month")
    private String nm_month;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "table_month_debt",
            joinColumns = @JoinColumn(name = "id_month", referencedColumnName = "id_month"),
            inverseJoinColumns = @JoinColumn(name = "id_debt", referencedColumnName = "id_debt")
    )
    private List<DebtEntity> debit = new ArrayList<>();
}
