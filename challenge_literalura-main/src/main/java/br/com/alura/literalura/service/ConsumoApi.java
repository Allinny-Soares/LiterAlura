package br.com.alura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDadosLivros (String apiUrl){


        HttpClient cliente = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        //Enviando a solicitação e obtendo a resposta
        HttpResponse<String> response = null;
        try {
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
