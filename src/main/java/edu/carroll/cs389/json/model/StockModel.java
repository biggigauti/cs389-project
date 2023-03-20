package edu.carroll.cs389.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class StockModel {
    @JsonProperty("ticker")
    @NotNull
    private String ticker;

    @JsonProperty("price")
    @NotNull
    private Float price;

    @JsonProperty("shares")
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
