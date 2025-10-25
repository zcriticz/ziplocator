package io.github.zcriticz.ziplocator.main;

import io.github.zcriticz.ziplocator.util.ZipWriter;
import io.github.zcriticz.ziplocator.dto.ViaCEP;
import io.github.zcriticz.ziplocator.model.Address;
import io.github.zcriticz.ziplocator.service.Zip;
import io.github.zcriticz.ziplocator.util.JsonParser;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner input = new Scanner(System.in);
        Zip zipService = new Zip();
        System.out.print("Enter a zip code: ");
        String zip = input.nextLine();

        try {
            String address = zipService.getAddressByZip(zip);
            ViaCEP viaCEP = JsonParser.fromJson(address, ViaCEP.class);
            Address convertedAddress = new Address(viaCEP);
            System.out.println(convertedAddress);

            ZipWriter.writeToFile("address.json", address);

        } catch (Exception e) {
            System.out.println("Error fetching address: " + e.getMessage());
        }
    }
}