package com.conversor.monedas.utils;

/**
 * Representa una moneda con su código, nombre y país.
 */
public class Currency {
    private final String code;
    private final String name;
    private final String country;

    public Currency(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", code, name, country);
    }
}
