package com.github.zcriticz.ziplocator.api;

import com.github.zcriticz.ziplocator.dto.ViaCEP;
import com.github.zcriticz.ziplocator.models.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Search {
    static void main() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digit your ZIP Code");
        String zipCode = input.nextLine();
        URI apiAddress = URI.create("https://viacep.com.br/ws/" + zipCode + "/json/");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(String.valueOf(apiAddress)))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ViaCEP viaCEP = gson.fromJson(response.body(), ViaCEP.class);
            Address address = new Address(viaCEP);
            System.out.println(address);

            FileWriter fileWriter = new FileWriter("address.json");
            gson.toJson(address, fileWriter);
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
