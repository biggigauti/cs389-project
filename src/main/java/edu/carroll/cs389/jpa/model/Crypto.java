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
    @Column(name = "userId")
    private String userId;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "buy_price")
    private float buyPrice;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getShares() {
        return shares;
    }

    public void setShares(float shares) {
        this.shares = shares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crypto crypto = (Crypto) o;
        return Float.compare(crypto.buyPrice, buyPrice) == 0 && Float.compare(crypto.shares, shares) == 0 && Objects.equals(ticker, crypto.ticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, buyPrice, shares);
    }
}
