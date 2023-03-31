package edu.carroll.cs389.web.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * When the user inserts a new stock holding or position they will submit a StockForm.
 *
 * The StockForm allows us to validate and store the content that the user submits.
 */
public class StockForm {

    @NotNull
    //Future-proof? NYSE currently allows up to 4. Nasdaq currently allows up to 5.
    //What about ETFs and Index funds? Do they allow more?
    @Size(max = 10, message = "Ticker symbol can not be longer than 10 characters long")
    private String ticker;

    @NotNull
    @Size(max = 20, message = "Buy price can not be longer than 20 characters long")
    private Float buyPrice;

    @NotNull
    @Size(max = 20, message = "Shares can not be longer than 20 characters long")
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
