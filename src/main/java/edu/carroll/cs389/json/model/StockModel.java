package edu.carroll.cs389.json.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The StockModel class is a JSON model that allows us to turn our JSON strings into
 * Java objects. We need to do this so Java understands what it's receiving
 * and storing in the database.
 *
 * We use some validation annotations in here: NotNull and Size.
 *
 * NotNull: Ensures that the data received is not null.
 * Size: Ensures that the data received is no longer than 10 characters.
 */
public class StockModel {
    @NotNull
    //Future-proof? NYSE currently allows up to 4. Nasdaq currently allows up to 5.
    //What about ETFs and Index funds? Do they allow more?
    @Size(max = 10, message = "Ticker symbol can not be longer than 10 characters long")
    private String ticker;

    @NotNull
    private Float price;

    @NotNull
    private Float shares;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getShares() {
        return shares;
    }

    public void setShares(Float shares) {
        this.shares = shares;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
