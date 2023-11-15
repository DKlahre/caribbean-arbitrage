package com.codeinvestigator.multiple_datasources.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Getter
@Setter
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "transaction_dump3", schema = "cruise_trade")
public class TransactionDump {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "provisioner_name", nullable = false)
    private String provisionerName;

    @Column(name = "country_of_business", nullable = false)
    private String countryOfBusiness;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Column(name = "purchase_total", nullable = false)
    private  Double purchaseTotal;

    @NotBlank(message = "transType cannot be blank")
    @Column(name = "trans_type")
    private String transType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' T'hh:mm:ss")
    @Column(name = "purch_date", nullable = false)
    private Date purchDate;

    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    public void setPurchDate(Date purchDate) {
        this.purchDate = purchDate;
    }
}
