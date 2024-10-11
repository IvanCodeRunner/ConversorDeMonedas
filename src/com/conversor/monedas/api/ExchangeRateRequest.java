package com.conversor.monedas.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.HttpURLConnection;


public class ExchangeRateRequest {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "d85c5fd6902cb264113f22c3"; // Reemplazar si se utiliza otra API_KEY

    /**
     * Envía una solicitud HTTP a la API de tasas de cambio con los códigos de moneda especificados.
     *
     * @param baseCode la moneda base (ej. "USD").
     * @param targetCode la moneda objetivo (ej. "ARS").
     * @return la respuesta de la API como un objeto ExchangeRateResponse.
     * @throws IOException si ocurre un problema al realizar la solicitud.
     * @throws InterruptedException si la operación es interrumpida.
     */
    public ExchangeRateResponse sendRequest(String baseCode, String targetCode) throws IOException, InterruptedException {
        String apiUrl = BASE_URL + API_KEY + "/pair/" + baseCode + "/" + targetCode;

        // Crear cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Crear solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        // Enviar solicitud y obtener respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Validar que la respuesta HTTP sea 200 OK
        if (response.statusCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Error en la API: Código de estado " + response.statusCode());
        }

        // Pasar la respuesta al constructor de ExchangeRateResponse
        return new ExchangeRateResponse(response.body());
    }
}
