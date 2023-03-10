package edu.carroll.cs389.web.form;

import jakarta.validation.constraints.NotNull;

/**
 * When the user inserts a new stock holding or position they will submit a StockForm.
 *
 * The StockForm allows us to validate and store the content that the user submits.
 */
public class StockForm {

    @NotNull
    private String ticker;

    @NotNull
    private Float buyPrice;

    @NotNull
    private Float shares;

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
}
