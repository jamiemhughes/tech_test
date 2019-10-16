package net.jamie.datamodels;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CurrencyItem implements Comparable<CurrencyItem>{
    private String name;
    private String mcap;
    private String price;
    private String volume;
    private String supply;

    public String getName() {
        return name;
    }

    public CurrencyItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getMcap() {
        return mcap;
    }

    public CurrencyItem setMcap(String mcap) {
        this.mcap = mcap;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public CurrencyItem setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public CurrencyItem setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getSupply() {
        return supply;
    }

    public CurrencyItem setSupply(String supply) {
        this.supply = supply;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyItem that = (CurrencyItem) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mcap, price, volume, supply);
    }

    @Override
    public int compareTo(@NotNull CurrencyItem o) {
        return this.hashCode() - o.hashCode();
    }
}
