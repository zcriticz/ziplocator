package com.github.zcriticz.ziplocator.model;

import com.github.zcriticz.ziplocator.dto.ViaCEP;

public class Address {
    private String zip;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    public Address(ViaCEP viaCEP) {
        this.zip = viaCEP.cep();
        this.street = viaCEP.logradouro();
        this.complement = viaCEP.complemento();
        this.neighborhood = viaCEP.bairro();
        this.city = viaCEP.localidade();
        this.state = viaCEP.uf();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Zip=" + zip + '\'' +
                "Street='" + street + '\'' +
                "Complement='" + complement + '\'' +
                "Neighborhood='" + neighborhood + '\'' +
                "City='" + city + '\'' +
                "State='" + state + '\'' +
                '}';
    }
}
