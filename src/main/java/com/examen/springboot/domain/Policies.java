package com.examen.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import java.math.BigDecimal;

@Entity
public class Policies {

    @Id
    private String id;

    @Column(name = "`amount_insured`")
    private BigDecimal amountInsured;

    private String email;

    @Column(name = "`inception_date`")
    private String inceptionDate;

    @Column(name = "`installment_payment`")
    private Boolean installmentPayment;

    @Column(name = "`client_id`")
    private Boolean clientId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmountInsured() {
        return amountInsured;
    }

    public void setAmountInsured(BigDecimal amountInsured) {
        this.amountInsured = amountInsured;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public Boolean getInstallmentPayment() {
        return installmentPayment;
    }

    public void setInstallmentPayment(Boolean installmentPayment) {
        this.installmentPayment = installmentPayment;
    }

    public Boolean getClientId() {
        return clientId;
    }

    public void setClientId(Boolean clientId) {
        this.clientId = clientId;
    }
}
