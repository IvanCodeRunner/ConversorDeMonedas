package com.conversor.monedas.api;

import java.io.IOException;

public class ExchangeRateClient {
    private final ExchangeRateRequest request;

    public ExchangeRateClient() {
        this.request = new ExchangeRateRequest();
    }

    /**
     * Realiza la solicitud para obtener las tasas de cambio.
     *
     * @return la respuesta de la API como un objeto ExchangeRateResponse.
     * @throws IOException si ocurre un problema al realizar la solicitud.
     * @throws InterruptedException si la operación es interrumpida.
     */
    public ExchangeRateResponse getLatestExchangeRates(String baseCode, String targetCode) throws IOException, InterruptedException {
        try{
            return request.sendRequest(baseCode, targetCode); // Enviar la solicitud y obtener la respuesta
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al enviar la solicitud: " + e.getMessage());
            throw e;
        }

    }
}
