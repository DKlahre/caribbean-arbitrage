package com.codeinvestigator.multiple_datasources.orderpojos;

import com.codeinvestigator.multiple_datasources.emp.Employees;
import com.codeinvestigator.multiple_datasources.pass.Passengers;
import lombok.Data;
import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import static com.codeinvestigator.multiple_datasources.constants.CurrCodeConstants.Barbados_Conv;


@Getter
@Setter
@RequiredArgsConstructor
@Data
@Table(name = "submit_order", schema = "cruise_trade")
@Entity


public class SubmitOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "provisioner")
    private String provisioner;

    @Column(name = "item")
    private String item;

    @Column(name = "item_cost_nat")
    private Double itemCostNat;

    @Column(name = "item_cost_us")
    private Double itemCostUs;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "item_total_cost_us")
    private Double itemTotalCostUs;

    @Column(name = "purch_date")
    private String purchDate;

    @Column(name = "all_items_cost")
    private Double allItemsCost;


}