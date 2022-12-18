package com.decagon.OakLandv1be.entities;

import com.decagon.OakLandv1be.enums.BaseCurrency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "wallet_tbl")
public class Wallet extends BaseEntity{

    private Double accountBalance;

    @Enumerated(EnumType.STRING)
    private BaseCurrency baseCurrency;

    @JsonIgnore
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Transaction> transactions;

    @JsonIgnore
    @OneToOne(mappedBy = "wallet", cascade = CascadeType.ALL)
    private Customer customer;


}
