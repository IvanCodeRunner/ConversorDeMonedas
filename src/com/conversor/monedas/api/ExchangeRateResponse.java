package com.conversor.monedas.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExchangeRateResponse {
    private final String baseCode;
    private final String targetCode;
    private final double conversionRate;

    /**
     * Constructor que toma la respuesta JSON como cadena y la parsea usando Gson.
     *
     * @param jsonResponse La respuesta JSON de la API en formato de cadena.
     */
    public ExchangeRateResponse(String jsonResponse) {
        // Parsear el JSON usando Gson
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

        // Extraer los datos relevantes del JSON
        this.baseCode = jsonObject.get("base_code").getAsString();
        this.targetCode = jsonObject.get("target_code").getAsString();
        this.conversionRate = jsonObject.get("conversion_rate").getAsDouble();
    }

    /**
     * Obtiene la tasa de conversión.
     *
     * @return la tasa de conversión entre las monedas.
     */
    public double getConversionRate() {
        return conversionRate;
    }

    /**
     * Obtiene el código de la moneda base.
     *
     * @return el código de la moneda base.
     */
    public String getBaseCode() {
        return baseCode;
    }

    /**
     * Obtiene el código de la moneda objetivo.
     *
     * @return el código de la moneda objetivo.
     */
    public String getTargetCode() {
        return targetCode;
    }

    /**
     * Imprime los detalles de la respuesta de una manera más legible.
     *
     * @return un String con los detalles de la respuesta.
     */
    @Override
    public String toString() {
        return "Conversión desde " + baseCode + " a " + targetCode + ": " + conversionRate;
    }
}
