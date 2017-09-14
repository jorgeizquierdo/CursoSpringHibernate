package com.hiberus.api.model.customer;

import javax.persistence.*;

/**
 * Created by jorge on 12/06/2016.
 */
@Entity(name = "customerSocialNetworks")
@Table(name = "customer_social_networks")
public class CustomerSocialNetworks {

    @Id
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "twitter")
    private String twitter;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
