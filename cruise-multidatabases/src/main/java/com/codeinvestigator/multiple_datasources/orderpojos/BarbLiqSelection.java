package com.codeinvestigator.multiple_datasources.orderpojos;

import static com.codeinvestigator.multiple_datasources.constants.CurrCodeConstants.Barbados_Conv;

import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbLiqSelectionRepository;
import com.codeinvestigator.multiple_datasources.orderpojos.repository.BarbadosOrderRepository;
import com.codeinvestigator.multiple_datasources.orderpojos.service.BarbLiqSelectionService;
import com.codeinvestigator.multiple_datasources.orderpojos.service.BarbLiqSelectionServiceImpl;
import com.codeinvestigator.multiple_datasources.orderpojos.service.BarbadosOrderServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.orm.hibernate5.SpringSessionSynchronization;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@RequiredArgsConstructor
@Data
@Table(name = "barb_liq_selection", schema = "cruise_order")
@Entity


public class BarbLiqSelection {

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

