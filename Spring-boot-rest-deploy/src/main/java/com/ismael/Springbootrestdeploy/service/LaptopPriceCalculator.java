package com.ismael.Springbootrestdeploy.service;


import com.ismael.Springbootrestdeploy.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){

        double price = 200;

        if(laptop.getTamaño() > 20){

            price += 50;
            return price;
        }
        // envio
        return price + 4.99;

    }
}
