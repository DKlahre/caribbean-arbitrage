package com.codeinvestigator.multiple_datasources.orderpojos;


import lombok.Data;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import static com.codeinvestigator.multiple_datasources.constants.CurrCodeConstants.Barbados_Conv;
import static com.codeinvestigator.multiple_datasources.constants.CurrCodeConstants.Martinique_Conv;


@Getter
@Setter
@RequiredArgsConstructor
@Data
@Table(name = "barb_toiletry_order", schema = "cruise_trade")
@Entity
public class BarbToiletryOrder {

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


    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemCostUs() {
        return itemCostUs;
    }
    public void setItemCostUs(Double itemCostUs) {
        BigDecimal big = Martinique_Conv.multiply(new BigDecimal(itemCostNat));
        this.itemCostUs = big.doubleValue();
    }
    public String getPurchDate() {
        return purchDate;
    }
    public void setPurchDate(String purchDate) {
        this.purchDate = purchDate;
    }

    public void setItemTotalCostUs(double itemTotalCostUs) {
        this.itemTotalCostUs = getItemCostUs() * getQuantity();
    }



}
