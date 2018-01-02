package com.company.gocardless.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentDetailsResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String customer;
    private String mandate;

    @java.beans.ConstructorProperties({"id", "customer", "mandate"})
    public PaymentDetailsResponse(long id, String customer, String mandate) {
        this.id = id;
        this.customer = customer;
        this.mandate = mandate;
    }

    public PaymentDetailsResponse() {
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getMandate() {
        return this.mandate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setMandate(String mandate) {
        this.mandate = mandate;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PaymentDetailsResponse)) return false;
        final PaymentDetailsResponse other = (PaymentDetailsResponse) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$customer = this.getCustomer();
        final Object other$customer = other.getCustomer();
        if (this$customer == null ? other$customer != null : !this$customer.equals(other$customer)) return false;
        final Object this$mandate = this.getMandate();
        final Object other$mandate = other.getMandate();
        if (this$mandate == null ? other$mandate != null : !this$mandate.equals(other$mandate)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $customer = this.getCustomer();
        result = result * PRIME + ($customer == null ? 43 : $customer.hashCode());
        final Object $mandate = this.getMandate();
        result = result * PRIME + ($mandate == null ? 43 : $mandate.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PaymentDetailsResponse;
    }

    public String toString() {
        return "PaymentDetailsResponse(id=" + this.getId() + ", customer=" + this.getCustomer() + ", mandate=" + this.getMandate() + ")";
    }
}
