package com.kukuruznyak.parser.domain;

import java.math.BigDecimal;

public class Currency {
    private Long id;
    private String name;
    private String shortName;
    private BigDecimal rate;
    private String exchangeDate;

    public Currency() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (id != null ? !id.equals(currency.id) : currency.id != null) return false;
        if (name != null ? !name.equals(currency.name) : currency.name != null) return false;
        if (shortName != null ? !shortName.equals(currency.shortName) : currency.shortName != null) return false;
        if (rate != null ? !rate.equals(currency.rate) : currency.rate != null) return false;
        return exchangeDate != null ? exchangeDate.equals(currency.exchangeDate) : currency.exchangeDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (exchangeDate != null ? exchangeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: '" + name + '\'' +
                ", shortName: '" + shortName + '\'' +
                ", rate: " + rate +
                ", exchangeDate: " + exchangeDate;
    }
}
