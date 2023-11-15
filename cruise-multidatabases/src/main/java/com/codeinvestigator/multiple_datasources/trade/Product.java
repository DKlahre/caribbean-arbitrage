package com.codeinvestigator.multiple_datasources.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
@Table(name = "product3", schema = "cruise_trade")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "productName cannot be blank")
    @NonNull
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotBlank(message = "productDescription cannot be blank")
    @NonNull
    @Column(name = "product_description", nullable = false)
    private String productDescription;

   // @NonNull
    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @NonNull
    @Column(name = "trans_available", nullable = false)
    private String transAvailable;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Provisioner> provisioners;

}
