package com.codeinvestigator.multiple_datasources.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.OneToMany;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
@Table(name = "country2", schema = "cruise_trade")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "countryName cannot be blank")
    @NonNull
    @Column(name = "country_name")
    private String countryName;

    @NotBlank(message = "natCurrency cannot be blank")
    @NonNull
    @Column(name = "nat_currency")
    private String natCurrency;

    @Column(name = "tax_rate")
    private Double taxRate;

    @NotBlank(message = "portName cannot be blank")
    @NonNull
    @Column(name = "port_name")
    private String portName;

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Provisioner> provisioners;

}
