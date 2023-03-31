package edu.carroll.cs389.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    public String toString() {
        return "StockModel{" +
                "ticker='" + ticker + '\'' +
                ", buyPrice=" + price +
                ", shares=" + shares +
                '}';
    }
}
