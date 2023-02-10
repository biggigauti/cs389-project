package edu.carroll.cs389.jpa.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crypto")
public class Crypto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    //foreign key
    @Column(name = "username")
    private String username;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "buy_price")
    private float buy_price;

    //@Column(name = "current_price")
    //private float current_price;

    @Column(name = "shares")
    private float shares;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(float buy_price) {
        this.buy_price = buy_price;
    }

    public float getShares() {
        return shares;
    }

    public void setShares(float shares) {
        this.shares = shares;
    }

    public float getTotal_value() {
        return total_value;
    }

    public void setTotal_value(float total_value) {
        this.total_value = total_value;
    }

    @Column(name = "total_value")
    private float total_value;
}
