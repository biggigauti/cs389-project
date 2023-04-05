package edu.carroll.cs389.jpa.model;

import java.util.Objects;
import jakarta.persistence.*;

/**
 * The Stock class is a JPA model that interacts with our database. Rather than creating the
 * tables and rows ourselves, this class takes care of that and represents the table.
 * This table stores an entry's UID, User associated with this position,
 * the stock's ticker symbol, the buy price, and the amount of shares associated with the position.
 */

//Entity simply represents a table stored in our database.
@Entity
@Table(name = "stock")
public class Stock {
    private static final long serialVersionUID = 1L;

    //GeneratedValue auto generates the id for us.
    @Id
    @GeneratedValue
    private Long id;

    //Linking user to the User table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "buy_price")
    private Float buyPrice;

    @Column(name = "shares")
    private Float shares;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User myUser) {
        this.user = myUser;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Float getShares() {
        return shares;
    }

    public void setShares(Float shares) {
        this.shares = shares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Float.compare(stock.shares, shares) == 0 && Objects.equals(ticker, stock.ticker) && Objects.equals(buyPrice, stock.buyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, buyPrice, shares);
    }
}