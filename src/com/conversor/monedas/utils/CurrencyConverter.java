package com.conversor.monedas.utils;

import com.conversor.monedas.api.ExchangeRateClient;
import com.conversor.monedas.api.ExchangeRateResponse;

import java.io.IOException;

/**
 * Clase responsable de convertir monedas utilizando un cliente de tasas de cambio.
 */
public class CurrencyConverter {
    private final ExchangeRateClient exchangeRateClient;

    public CurrencyConverter() {
        this.exchangeRateClient = new ExchangeRateClient();
    }

    /**
     * Convierte un monto de dinero de una moneda a otra.
     *
     * @param baseCode el código de la moneda base (ej. "USD").
     * @param targetCode el código de la moneda objetivo (ej. "ARS").
     * @param amount la cantidad a convertir.
     * @return la cantidad convertida en la moneda objetivo.
     * @throws IOException si ocurre un problema al realizar la solicitud.
     * @throws InterruptedException si la operación es interrumpida.
     */
    public double convert(String baseCode, String targetCode, double amount) throws IOException, InterruptedException {
        ExchangeRateResponse response = exchangeRateClient.getLatestExchangeRates(baseCode, targetCode);

        // Verifica si el código de moneda es válido
        if (response == null) {
            throw new IllegalArgumentException("El código de moneda no es válido.");
        }

        return amount * response.getConversionRate(); // Convierte el monto
    }
}
