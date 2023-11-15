package com.codeinvestigator.multiple_datasources.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "provisioner5", schema = "cruise_trade")
public class Provisioner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "provisionerName cannot be blank")
    @Column(name = "provisioner_name", nullable = false)
    private String provisionerName;

    @NotBlank(message = "countryOfBusiness cannot be blank")
    @Column(name = "country_of_business", nullable = false)
    private String countryOfBusiness;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Column(name = "purchase_total", nullable = false)
    private  Double purchaseTotal;

    @NotBlank(message = "transType cannot be blank")
    @Column(name = "trans_type", nullable = false)
    public String transType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' T'hh:mm:ss")
    @Column(name = "purch_date", nullable = false)
    private Date purchDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public void setPurchDate(String purchDate) {
        Date todayDate = new Date();
        this.purchDate = todayDate;
    }

    public void setProductQuantity(Integer productQuantity){
        this.productQuantity = productQuantity;
    }

    public void setPurchaseTotal(Double newPrice) {

        BigDecimal bd1 = new BigDecimal(productQuantity);
        BigDecimal bd2 = new BigDecimal(newPrice);
        BigDecimal bigNewPrice = bd1.multiply(bd2);
        this.purchaseTotal = bigNewPrice.doubleValue();

    }


}
