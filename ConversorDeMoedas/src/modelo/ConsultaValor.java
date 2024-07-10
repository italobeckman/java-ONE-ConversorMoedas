package modelo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaValor {
    private final String API_KEY;

    public ConsultaValor(String key) {
        this.API_KEY = key;
    }
    public Double getValorCambio(String moedaOrigem, String moedaDestino) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/" + this.API_KEY + "/pair/" + moedaOrigem +"/" + moedaDestino))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            JsonObject jsonResposta = gson.fromJson(response.body(), JsonObject.class);
            return jsonResposta.get("conversion_rate").getAsDouble();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consultar. Não foi possivel obter a cotação.");
        }
    }
}
