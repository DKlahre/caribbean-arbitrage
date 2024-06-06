package com.codeinvestigator.multiple_datasources.orderpojos;
import lombok.Data;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@RequiredArgsConstructor
@Data
@Table(name = "barb_toiletry", schema = "cruise_trade")
@Entity
public class BarbToiletry {

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
