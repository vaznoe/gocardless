package com.company.gocardless.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String customer;
    private String mandate;

}
