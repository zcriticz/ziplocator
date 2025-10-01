package com.github.zcriticz.ziplocator.main;

import com.github.zcriticz.ziplocator.util.ZipWriter;
import com.github.zcriticz.ziplocator.dto.ViaCEP;
import com.github.zcriticz.ziplocator.model.Address;
import com.github.zcriticz.ziplocator.service.Zip;
import com.github.zcriticz.ziplocator.util.JsonParser;

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